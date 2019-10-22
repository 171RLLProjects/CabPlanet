package com.mphasis.cab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.cab.daos.BookingDao;
import com.mphasis.cab.entities.Booking;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.util.Status;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDao bookingDao;
	
	public void addBooking(Booking booking) throws BusinessException {

		
		if(booking.getBid().matches("[B]{1}[I]{1}[_]{1}[0-9]{5}")) {
			
			bookingDao.addBooking(booking);
		}else  {throw new BusinessException("Booking id is not in format");   
		}
	
	}
	
		
	

	public void updateBooking(Booking booking) throws BusinessException {
		
		bookingDao.updateBooking(booking);// TODO Auto-generated method stub

	}

	
	public List<Booking> getAll() throws BusinessException {
		List<Booking> bookings=null;
	 
		bookings =  bookingDao.getAll();
		if(bookings.isEmpty()) {
			throw new BusinessException("Bookings not present");
		}
		
		return bookings;
	}

	public Booking getBookingById(String bid) throws BusinessException {
		// TODO Auto-generated method stub
		Booking booking=null;
		
		if(bid.startsWith("BI_")) {
		
			booking=bookingDao.getBookingById(bid);
			System.out.println(booking.getJourneyDate());
			
		}else {throw new BusinessException("id is not in format");}
		return booking;
		
	}

	public List<Booking> getBookingByLocation(Location source,Location destination) throws BusinessException{
		// TODO Auto-generated method stub
		List<Booking> bookings=null;
		
		bookings= bookingDao.getBookingByLocation(source,destination);
		
		
		if(bookings.isEmpty()) {
			throw new BusinessException("Bookings not present");
		}
		return bookings;
	}




	public List<Booking> getBookingByCustomer(String cid) throws BusinessException {
	
		List<Booking> bookings=null;
		
		if(cid.startsWith("CU_")) {
		
			bookings=bookingDao.getBookingByCustomer(cid);
			
			
		}else {throw new BusinessException("id is not in format");}
		
		if(bookings.isEmpty()) {
			throw new BusinessException("Bookings not present");
		}
		
		return bookings;
	}




	public List<Booking> getBookingByVehicle(String vid) throws BusinessException {
		// TODO Auto-generated method stub
		List<Booking>  bookings=null;
		if(vid.matches("[V]{1}[E]{1}[_]{1}[0-9]{5}")) {
		bookings=bookingDao.getBookingByVehicle(vid);
		} else {throw new BusinessException("id is not in format");}
		if(bookings.isEmpty()) {
			throw new BusinessException("Bookings not present");
		}
		return bookings;
	}




	public List<Booking> getBookingByRoute(String rid) throws BusinessException {
		// TODO Auto-generated method stub
		List<Booking>  bookings=null;
		if(rid.matches("[R]{1}[O]{1}[_]{1}[0-9]{5}")) {
		bookings= bookingDao.getBookingByRoute(rid);
		}else {throw new BusinessException("id is not in format");}
		if(bookings.isEmpty()) {
			throw new BusinessException("Bookings not present");
		}
		return bookings;
	}




	public void updateStatus(String bid, Status status) throws BusinessException {
		if(bid.startsWith("BI_")) {
			bookingDao.updateStatus(bid, status);
		}else {
			throw new BusinessException("bid is not in format");
		}
	}




	




	
}

	
		
	


