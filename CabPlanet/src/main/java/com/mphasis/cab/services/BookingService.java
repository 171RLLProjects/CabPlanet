package com.mphasis.cab.services;

import java.util.List;

import com.mphasis.cab.entities.Booking;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.util.Status;

public interface BookingService {

	public void addBooking(Booking b)throws BusinessException;
	public void updateBooking(Booking b)throws BusinessException;
	public List<Booking> getAll()throws BusinessException;
	public Booking getBookingById(String bid)throws BusinessException;
	public List<Booking> getBookingByLocation(Location source,Location destination) throws BusinessException;
	public List<Booking> getBookingByCustomer(String cid) throws BusinessException;
	public List<Booking> getBookingByVehicle(String vid) throws BusinessException;
	public List<Booking> getBookingByRoute(String rid) throws BusinessException;
	public void updateStatus(String bid,Status status)throws BusinessException;
}
