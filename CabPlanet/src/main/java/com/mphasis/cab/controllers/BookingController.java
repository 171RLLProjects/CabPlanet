package com.mphasis.cab.controllers;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.cab.entities.Booking;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.services.BookingService;
import com.mphasis.cab.util.Status;


@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;

	@RequestMapping(value="/booking",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Booking>> getBooking()
	{
		List<Booking> bookings = null;
		try
		{
			bookings = bookingService.getAll();
			return new ResponseEntity<List<Booking>>(bookings,HttpStatus.OK);
			
		} catch (BusinessException e)
		{
			e.printStackTrace();
			return new ResponseEntity<List<Booking>>(bookings,HttpStatus.BAD_REQUEST);
		}
		
		
	
	}
	 
	
// ADD BOOKING DETAILS____________________________________________________________________________________________________________
	
	@RequestMapping(value="/booking",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>> addBooking(@RequestBody Booking booking)
	{
		 Map<String,String> map=new HashMap<String, String>();
		try
		{
			bookingService.addBooking(booking);
			map.put("ok", "success saving data");
			return ResponseEntity.accepted().body(map);
		}catch (BusinessException e)
		{
			e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
	}
// UPDATE BOOKING DETAILS____________________________________________________________________________________________________________________	
	@RequestMapping(value="/booking",method=RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>>  updateBooking(@RequestBody Booking booking)
	{
		 Map<String,String> map=new HashMap<String, String>();
		try
		{
			bookingService.updateBooking(booking);
			map.put("ok", "success saving data");
			return ResponseEntity.accepted().body(map);
		}catch (BusinessException e)
		{
			e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@RequestMapping(value="/bookingb/{bid}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Booking> getBookingById(@PathVariable("bid")String bid) throws BusinessException
	{
		Booking booking;
		try {
			booking = bookingService.getBookingById(bid);
			return new ResponseEntity<Booking>(booking,HttpStatus.OK);
		}catch(Exception e)
		{
			//e.printStackTrace();
			return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
		
		}
	}
	
	@RequestMapping(value="/location/{source}/{destination}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Booking>> getBookingByLocation(@PathVariable("source")Location source,@PathVariable("source")Location destination) throws BusinessException
	{
	
		List<Booking> bookings =null;
		try
		{
			bookings=bookingService.getBookingByLocation(source,destination);
			return new ResponseEntity<List<Booking>>(bookings,HttpStatus.OK);
		}catch (BusinessException e)
		{
			e.printStackTrace();
			return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="/customerb/{cid}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Booking>> getBookingByCustomer(@PathVariable("cid")String cid) throws BusinessException
	{

		List<Booking> bookings =null;
		try
		{
			bookings=bookingService.getBookingByCustomer(cid);
			
		}catch (BusinessException e)
		{
			//e.printStackTrace();
			return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Booking>>(bookings,HttpStatus.OK);
	}
	@RequestMapping(value="/vehicleb/{vid}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Booking>> getBookingByVehicle(@PathVariable("vid")String vid) throws BusinessException
	{
	
		List<Booking> bookings =null;
		try
		{
			bookings=bookingService.getBookingByVehicle(vid);
			return new ResponseEntity<List<Booking>>(bookings,HttpStatus.OK);
		}catch (BusinessException e)
		{
			e.printStackTrace();
			return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value="/routeb/{rid}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  ResponseEntity<List<Booking>>getBookingByRoute(@PathVariable("rid")String rid) throws BusinessException
	{
		List<Booking> bookings =null;
		try
		{
			bookings=bookingService.getBookingByRoute(rid);
			return new ResponseEntity<List<Booking>>(bookings,HttpStatus.OK);
		}catch (BusinessException e)
		{
			//e.printStackTrace();
			return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
@RequestMapping(value="/booking/{bid}/{status}",method=RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> updateStatus(@PathVariable("bid")String bid,@PathVariable("status")Status status)
	{
		try
		{
			bookingService.updateStatus(bid, status);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch (BusinessException e)
		{
			//e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
