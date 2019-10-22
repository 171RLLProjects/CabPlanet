package com.mphasis.cab.services;

import java.util.List;

import com.mphasis.cab.entities.Vehicle;
import com.mphasis.cab.exceptions.BusinessException;

public interface VehicleService {

	public void addVehicle(Vehicle vehicle) throws BusinessException;
	public void changeVehicle(Vehicle vehicle) throws BusinessException;
	public void removeVehicle(String vid) throws BusinessException;
	public List<Vehicle> showVehiclebyvehicleTypes(String vtype,int vseatcapacity) throws BusinessException;

	public Vehicle showVehicleByID(String vid) throws BusinessException;
	public Vehicle showVehicleByDriverId(String did) throws BusinessException;
	
}
