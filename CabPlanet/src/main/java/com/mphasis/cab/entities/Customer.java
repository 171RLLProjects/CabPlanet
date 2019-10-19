package com.mphasis.cab.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.cab.util.StringPrefixedSequenceIdGenerator;


@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "use_seq")
	@GenericGenerator(name = "use_seq", 
	        strategy = "com.mphasis.cab.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "30"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CU_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(length=10)
	private String cid;
	@Column(length = 15, nullable=false)
	private String cfname;
	@Column(length = 15, nullable=false)
	private String clname;
	@Column(length = 15, nullable = false)
	private String dob;
	@Column(length = 10, nullable=false)
	private String Gender;
	@Column(length = 40, nullable=false)
	private String presentAddress;
	@Column(length = 40)
	private String permanentAddress;
	@Column(length = 10, nullable=false, unique = true)
	private long phoneNumber;
	@Column(length = 35, nullable=false, unique = true)
	private String email;
	@Column(length = 10, nullable=false)
	private String pwd;
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCfname() {
		return cfname;
	}
	public void setCfname(String cfname) {
		this.cfname = cfname;
	}
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
}
