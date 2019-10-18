package com.mphasis.cab.services;

import java.util.List;
import java.util.Set;

import com.mphasis.cab.entities.Location;
import com.mphasis.cab.exceptions.BusinessException;

public interface LocationService {
	public String addLocation(Location location)throws BusinessException;
	public void updateLocation(Location location)throws BusinessException;
	public void deleteLocation(String lid)throws BusinessException;
	public Location getLocationById(String lid)throws BusinessException;
	public Set<Location> getLocations()throws BusinessException;
	public List<Location> getLocationByName(String lname)throws BusinessException;
}
