package com.mphasis.cab.daos;

import java.util.List;

import com.mphasis.cab.entities.Booking;
import com.mphasis.cab.entities.Driver;
import com.mphasis.cab.exceptions.BusinessException;

public interface DriverDao {

	public Booking getBookingById(String bid) throws BusinessException;
	public void deleteBooking(String bid) throws BusinessException;
	public Driver loginDriver(String username, String password) throws BusinessException;
	
	public void insertDriverDetails(Driver driver) throws BusinessException;
	public void updateDriverDetails(Driver driver) throws BusinessException;
	public void updateDriverPassword(String did,String pwd) throws BusinessException;
	public void deleteDriverDetails(String did) throws BusinessException;
	public Driver getDriverDetailsById(String did) throws BusinessException;
	public List<Driver> getAllDrivers() throws BusinessException;
	
	
}
