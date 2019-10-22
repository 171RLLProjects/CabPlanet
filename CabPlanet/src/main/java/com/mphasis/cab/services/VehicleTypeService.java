package com.mphasis.cab.services;

import java.util.List;

import com.mphasis.cab.entities.VehicleType;
import com.mphasis.cab.exceptions.BusinessException;

public interface VehicleTypeService {

	public double viewfareByVehicleTypeID(String vtype,int vseatcapacity) throws BusinessException;
	public void insertvehicleType(VehicleType vehicletype) throws BusinessException;
	public void changeVehicleType(VehicleType vehicletype) throws BusinessException;
	public void removeVehicleType(String vtypeid) throws BusinessException;
	public List<VehicleType> getallVehicletypes() throws BusinessException;
	public VehicleType getvehicleTypeById(String vtypeid) throws BusinessException;
}
