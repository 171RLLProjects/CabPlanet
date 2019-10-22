package com.mphasis.cab.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.cab.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ro_seq")
	@GenericGenerator(name = "ro_seq", 
	        strategy = "com.mphasis.cab.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "RO_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(length = 10)
	private String rid;
	@ManyToOne
	@JoinColumn(name="sourceLocId")
	private Location source;
	@ManyToOne
	@JoinColumn(name="destinationLocId")
	private Location destination;
	@Column(precision = 10, scale = 3, nullable = false)
	private double distance;
	@Column(length = 4, nullable=false)
	private int duration;
	@ManyToOne
	@JoinColumn(name="middlePointLocId")
	private Location middlePoint;
	
	
	
	
	
	public Location getMiddlePoint() {
		return middlePoint;
	}
	public void setMiddlePoint(Location middlePoint) {
		this.middlePoint = middlePoint;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public Location getSource() {
		return source;
	}
	public void setSource(Location source) {
		this.source = source;
	}
	public Location getDestination() {
		return destination;
	}
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
	
	
}
