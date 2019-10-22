package com.mphasis.cab.services;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.cab.daos.DriverDao;
import com.mphasis.cab.entities.Booking;
import com.mphasis.cab.entities.Driver;
import com.mphasis.cab.exceptions.BusinessException;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired	
	private DriverDao driverDao;
	
	
	public Booking getBookingByid(String bid) throws BusinessException{
		// TODO Auto-generated method stub
		
		Booking b = driverDao.getBookingById(bid);
		if(b == null)
		{
			throw new BusinessException("No booking id available");
		}
		return b;
	}

	public void deleteBooking(String bid) throws BusinessException{
		// TODO Auto-generated method stub
		driverDao.deleteBooking(bid);
		
	}

	public Driver loginDriver(String username, String password) throws BusinessException{
		// TODO Auto-generated method stub
		
		Driver driver1 = null;
		if(username.matches("[A-Za-z]{3,20}"))
		{
			if(password.matches("[A-Za-z]{3,10}")) 
			{
				driver1 = driverDao.loginDriver(username, password);
			}else throw new BusinessException("Password should not be less than 3 characters and more than 10 characters");
		}else throw new BusinessException("Name is invalid");
		
		if(driver1 == null)
		{
			throw new BusinessException("Invalid Credentials");
		}
		return driver1;
	}

	public void insertDriverDetails(Driver driver) throws BusinessException{
		// TODO Auto-generated method stub
		long contactnumber = driver.getContactno();
		Long longInstance = new Long(contactnumber);
		String connumber =  longInstance.toString();
		if(driver.getDname().matches("[A-Za-z]{3,20}"))
		{
			if(driver.getAddress().matches("[A-Za-z]{3,40}")) 
			{
				if( connumber.matches("[0-9]{10}"))
				{
					if(driver.getLicenseNumber().matches("[A-Z]{2}[0-9]{2}[0-9]{4}[0-9]{7}$")) 
					{
						if(driver.getPwd().matches("[A-Za-z0-9@_]{8,10}")) 
						{
						driverDao.insertDriverDetails(driver);
						}else throw new BusinessException("Password should not be less than 3 characters and more than 10 characters");
					}else throw new BusinessException("Licence Number should be valid");
				}else throw new BusinessException("Contact number should not be greater than 10");
			}else throw new BusinessException("Address is invalid");
		}else throw new BusinessException("Name is invalid");
	}

	public void updateDriverDetails(Driver driver) throws BusinessException{
		// TODO Auto-generated method stub
		long contactnumber = driver.getContactno();
		Long longInstance = new Long(contactnumber);
		String connumber =  longInstance.toString();
		if(driver.getDname().matches("[A-Za-z]{3,20}"))
		{
			if(driver.getAddress().matches("[A-Za-z]{3,40}")) 
			{
				if( connumber.matches("[0-9]{10}"))
				{
					if(driver.getLicenseNumber().matches("[A-Z]{2}[0-9]{2}[0-9]{4}[0-9]{7}$")) 
					{
						if(driver.getPwd().matches("[A-Za-z0-9@_]{8,10}")) 
						{
							driverDao.updateDriverDetails(driver);
						}else throw new BusinessException("Password should not be less than 3 characters and more than 10 characters");
					}else throw new BusinessException("Licence Number should be valid");
				}else throw new BusinessException("Contact number should not be greater than 10");
			}else throw new BusinessException("Address is invalid");
		}else throw new BusinessException("Name is invalid");
	}

	public void deleteDriverDetails(String did) throws BusinessException{
		// TODO Auto-generated method stub
		if(did.matches("[D]{1}[R]{1}[_]{1}[0-9]{5}") && did!=null)
		{
		driverDao.deleteDriverDetails(did);
		}
		else throw new BusinessException("Not a valid Driver id");
	}

	public Driver getDriverDetailsById(String did) throws BusinessException{
		// TODO Auto-generated method stub
		Driver driver=null;
		if(did.matches("[D]{1}[R]{1}[_]{1}[0-9]{5}"))
		{
			driver = driverDao.getDriverDetailsById(did);
	
		}
		if(driver == null) {
			throw new BusinessException("No driver available");
		}
		return driver;	
		
	}

	public List<Driver> getAllDrivers() throws BusinessException{
		// TODO Auto-generated method stub
		List<Driver> drivers = null;
		
		drivers = driverDao.getAllDrivers();
		if(drivers == null)
		{
			throw new BusinessException("No drivers available");
		}
		return drivers;
	}

	public void changeDriverPassword(String did,String pwd) throws BusinessException {
		// TODO Auto-generated method stub
	
		if(pwd.matches("[A-Za-z0-9@_]{8,10}")) {
		driverDao.updateDriverPassword(did,pwd);
		}else throw new BusinessException("Invalid password format");
		
	}

	
}
