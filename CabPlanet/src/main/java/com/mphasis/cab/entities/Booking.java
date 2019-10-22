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
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
	
	
	
	
}
