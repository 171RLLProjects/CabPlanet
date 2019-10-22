package com.mphasis.cab.daos;

import java.util.List;

import com.mphasis.cab.entities.VehicleType;
import com.mphasis.cab.exceptions.BusinessException;

public interface VehicleTypeDao {

	public void addVehicleType(VehicleType vehicletype) throws BusinessException;
	public void deleteVehicleType(String vtypeid) throws BusinessException;
	public void updateVehicleType(VehicleType vehicletype) throws BusinessException;
	public List<VehicleType> retrieveAllVehicletypes() throws BusinessException;
	public double getfarebyVehicleType(String vtype,int vseatcapacity) throws BusinessException;
	public VehicleType getVehicleTypeByID(String vtypeid) throws BusinessException;
	
}
