package com.mphasis.cab.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.cab.util.StringPrefixedSequenceIdGenerator;

 enum Status {
    waiting, confirmed, arrived, cancelled
}
@Entity
@DynamicInsert
@DynamicUpdate
public class Booking {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "booking_seq")
	@GenericGenerator(name = "booking_seq", 
	        strategy = "com.mphasis.cab.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "BI_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(length = 10)
	private String bid;
	@Column(length = 10)
	private Status status;
	
	@Column(length = 35, columnDefinition = "date default sysdate", insertable=false, updatable=false)
	private String bookingDate;
	@Column(length = 35, updatable=false)
	private String journeyDate                                                                                                                                                                                                                                                                                                                                                                                                                                                             ;
	@Column(length = 20, nullable = false)
	private double totalFare;
	
	@OneToOne
	@JoinColumn(name ="cid")
	private Customer customer;
	@OneToOne
	@JoinColumn(name ="vid")
	private Vehicle vehicle;
	@OneToOne
	@JoinColumn(name ="rid")
	private Route route;
	@OneToOne
	@JoinColumn(name ="did")
	private Driver driver;
	
	
	
	
}
