package com.mphasis.cab.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.cab.daos.LocationDao;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.exceptions.BusinessException;
@Service
public class LocationServiceImpl implements LocationService{
	@Autowired
	private LocationDao locationDao;

	public void addLocation(Location location) throws BusinessException {
		if(location.getLid().matches("[a-zA-Z0-9]+")) {
		if(location.getLname().matches("[A-Za-z]{8,15}")) {
			
						locationDao.addLocation(location);
					
		}else {
			throw new BusinessException("Location name doesnt match");}
	}else {
		throw new BusinessException("Location id doesnt match");}
	}

	public void updateLocation(Location location) throws BusinessException {
		if(location.getLid().matches("[a-zA-Z0-9]+")) {
			if(location.getLname().matches("[A-Za-z]{8,15}")) {
				
							locationDao.updateLocation(location);
						
			}else {
				throw new BusinessException("Location name doesnt match");}
		}else {
			throw new BusinessException("Location id doesnt match");}
	}

	public void deleteLocation(String lid) throws BusinessException {
		if(lid.startsWith("LO_") && lid.length()==8) {
			locationDao.deleteLocation(lid);
		}else {
			throw new BusinessException("id does not match with the existing Pattern");
		}
		
	}

	public Location getLocationById(String lid) throws BusinessException {
		Location l=null;
		try{
			l=locationDao.getLocationById(lid);
		}catch (Exception e) {
			throw new BusinessException("Location id not exists in table");
		}
		if(l==null) {
			throw new BusinessException("The requested Location not available");
		}
		return l;
	}

	public Set<Location> getLocations() throws BusinessException {
		Set<Location> loc=null;
		try{
			loc=locationDao.getLocations();
		}catch (Exception e) {
			throw new BusinessException("The requested Locations not available");
		}
		if(loc==null) {
			throw new BusinessException("The requested Locations not available");
		}
		
		return loc; 
	}

	public Location getLocationByName(String lname) throws BusinessException {
		Location l=null;
		try {
		l=locationDao.getLocationByName(lname);
		
		if(l==null) {
			throw new BusinessException("The requested Location not available");
		}
		}catch(Exception e) {
			throw new BusinessException("The requested Location not available");
		}
		return l; 
	}

}
