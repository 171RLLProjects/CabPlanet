package com.mphasis.cab.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.cab.entities.*;
import com.mphasis.cab.util.StringPrefixedSequenceIdGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class VehicleType {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "vec_seq")
	@GenericGenerator(name = "vec_seq", 
	        strategy = "com.mphasis.cab.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "VT_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(length = 10)
	private String vTypeId;
	@Column(length = 35, nullable=false)
	private String vType;
	@Column(length = 2, nullable=false)
	private int vSeatCapacity;
	@Column(precision = 10, scale = 3, nullable = false)
	private double farePK;
	@OneToMany(mappedBy="vehicleType", fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Vehicle> vehicle;
	public String getvTypeId() {
		return vTypeId;
	}
	public void setvTypeId(String vTypeId) {
		this.vTypeId = vTypeId;
	}
	public String getvType() {
		return vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
	public int getvSeatCapacity() {
		return vSeatCapacity;
	}
	public void setvSeatCapacity(int vSeatCapacity) {
		this.vSeatCapacity = vSeatCapacity;
	}
	public double getFarePK() {
		return farePK;
	}
	public void setFarePK(double farePK) {
		this.farePK = farePK;
	}
	public Set<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	


	
	
	
	
}
