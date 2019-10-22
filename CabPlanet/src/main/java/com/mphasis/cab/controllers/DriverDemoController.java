package com.mphasis.cab.controllers;

import java.util.List;

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

import com.mphasis.cab.entities.Driver;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.services.DriverService;

@RestController
public class DriverDemoController {

	@Autowired
	DriverService driverService;
	
	// ADD DRIVER DETAILS__________________________________________________________________________________________
	
	@RequestMapping(value="/driver",method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> registerDriver(@RequestBody Driver driver)
	{
		
		try {
			driverService.insertDriverDetails(driver);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		} catch (BusinessException e) {
			// TODO: handle exception
			return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// GET DRIVER DETAILS BY ID________________________________________________________________________________________________
	
	@RequestMapping(value="/driver/{did}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Driver> getDriverById(@PathVariable("did")String did)
	{
		Driver d = null;
		try {
			d = driverService.getDriverDetailsById(did);
		} catch (BusinessException e) {
			// TODO: handle exception
			//e.printStackTrace();
			return new ResponseEntity<Driver>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Driver>(d,HttpStatus.OK);
		
	}
	
	//UPDATE DRIVER DETAILS___________________________________________________________________________________________
	
	@RequestMapping(value="/driverupdate",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> updateDriver(@RequestBody Driver driver)
	{
		
		try {
			driverService.updateDriverDetails(driver);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		} catch (BusinessException e) {
			// TODO: handle exception
			//e.printStackTrace();
			return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	//DELETE DRIVER DETAILS______________________________________________________________________________________________
	
	@RequestMapping(value="/driverdelete/{did}",method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> deleteDriver(@PathVariable("did") String did)
	{
		
		try {
			driverService.deleteDriverDetails(did);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		} catch (BusinessException e) {
			// TODO: handle exception
			//e.printStackTrace();
			return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
// UPDATE DRIVER PASSWORD______________________________________________________________________________________________
	
	
	
	@RequestMapping(value="/driverpassword/{did}/{pwd}",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> updateDriverPassword(@PathVariable("did") String did,@PathVariable("pwd")String pwd)
	{
		
		try {
			driverService.changeDriverPassword(did,pwd);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		} catch (BusinessException e) {
			// TODO: handle exception
			//e.printStackTrace();
			return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	// DRIVER LOGIN
	
	@RequestMapping(value="/login/{uname}/{pass}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Driver> loginDriver(@PathVariable("uname")String uname,@PathVariable("pass")String pass)
	{
		Driver driver=null;
		try {
			driver = driverService.loginDriver(uname, pass);
		} catch (BusinessException e) {
			// TODO: handle exception
			//e.printStackTrace();
			return new  ResponseEntity<Driver>(HttpStatus.BAD_REQUEST);
		}
	 return new  ResponseEntity<Driver>(driver,HttpStatus.OK);
		
		
	}
	
	
	
	/*//GET BOOKING BY ID___________________________________________________________________________________________________
	
	@RequestMapping(value="/booking/{bid}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public Booking getBookingById(@PathVariable("bid")String bid)
	{
		Booking b = null;
		try {
			b = driverService.getBookingByid(bid);
		} catch (BusinessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
		
	}
	
// 	DELETE BOOKING
	
	@RequestMapping(value="/bookingdelete/{bid}",method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
	public void deleteBooking(@PathVariable("bid") String bid)
	{
		
		try {
			driverService.deleteBooking(bid);
		} catch (BusinessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}*/
	
	
// GET ALL DRIVERS
	
	@RequestMapping(value="/dri",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Driver>> getDrivers()
	{
		List<Driver> drivers = null;
		try {
			drivers = driverService.getAllDrivers();
			return new ResponseEntity<List<Driver>>(drivers,HttpStatus.OK);
		} catch (BusinessException e) {
			// TODO: handle exception
			//e.printStackTrace();
			return new ResponseEntity<List<Driver>>(HttpStatus.NO_CONTENT);
		}
		
		
	}
	
}
