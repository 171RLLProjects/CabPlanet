package com.mphasis.cab.daos;

import java.util.List;

import com.mphasis.cab.entities.Vehicle;
import com.mphasis.cab.exceptions.BusinessException;

public interface VehicleDao {

	public void insertVehicle(Vehicle vehicle) throws BusinessException;
	public void updateVehicle(Vehicle vehicle) throws BusinessException;
	public void deleteVehicle(String vid) throws BusinessException;
	public List<Vehicle> getVehiclebyvehicleTypes(String vtype,int vseatcapacity) throws BusinessException;

	public Vehicle getVehicleByID(String vid) throws BusinessException;
	public Vehicle getVehicleByDriverId(String did) throws BusinessException;
	
	
}
