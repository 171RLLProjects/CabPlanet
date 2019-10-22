package com.mphasis.cab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.cab.daos.VehicleTypeDao;
import com.mphasis.cab.entities.Booking;
import com.mphasis.cab.entities.VehicleType;
import com.mphasis.cab.exceptions.BusinessException;
import java.lang.*;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

	@Autowired
	VehicleTypeDao vehicletypedao;
	
	public double viewfareByVehicleTypeID(String vtype,int vseatcapacity) throws BusinessException {
		// TODO Auto-generated method stub
		double fare = 0.0;
		if(vtype.matches("[A-Za-z]{3,10}")) {
		try {
			fare = vehicletypedao.getfarebyVehicleType(vtype, vseatcapacity);
			return fare;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else throw new BusinessException("Not valid vtype or seat type");
		return fare;
	}

	public void insertvehicleType(VehicleType vehicletype) throws BusinessException {
		// TODO Auto-generated method stub
		int seats = vehicletype.getvSeatCapacity();
		Integer integerinstance = new Integer(seats);
		String seats1 = integerinstance.toString();
		double faren = vehicletype.getFarePK();
		Double floatinstance =  new Double(faren);
		String fare = floatinstance.toString();
		
		if(seats1.matches("[0-9]{1}")) {
			if(vehicletype.getvType().matches("[A-Za-z]{2,10}")) {
				if(fare.matches("[0-9]{1,4}[.]{1}[0-9]{1,2}")) {
						vehicletypedao.addVehicleType(vehicletype);
				}else throw new BusinessException("Not a valid fare");
			}else throw new BusinessException("Not a valid vehicle type!");
		}else throw new BusinessException("Not a valid seat Type!");
		
	}

	public void changeVehicleType(VehicleType vehicletype) throws BusinessException {
		// TODO Auto-generated method stub
		int seats = vehicletype.getvSeatCapacity();
		Integer integerinstance = new Integer(seats);
		String seats1 = integerinstance.toString();
		double faren = vehicletype.getFarePK();
		Double floatinstance =  new Double(faren);
		String fare = floatinstance.toString();
		
		if(seats1.matches("[0-9]{1}")) {
			if(vehicletype.getvType().matches("[A-Za-z]{2,10}")) {
				if(fare.matches("[0-9]{1,4}[.]{1}[0-9]{}1,2")) {
						vehicletypedao.updateVehicleType(vehicletype);
				}else throw new BusinessException("Not a valid fare");
			}else throw new BusinessException("Not a valid vehicle type!");
		}else throw new BusinessException("Not a valid seat Type!");
	}

	public void removeVehicleType(String vtypeid) throws BusinessException {
		// TODO Auto-generated method stub
		if(vtypeid.matches("[V]{1}[T]{1}[_]{1}[0-9]{5}"))
		{
		vehicletypedao.deleteVehicleType(vtypeid);
		}else throw new BusinessException("Not a valid vehicle type id");
	}

	public List<VehicleType> getallVehicletypes() throws BusinessException {
		// TODO Auto-generated method stub
		List<VehicleType> vehicletypes =null;
		
		vehicletypes =  vehicletypedao.retrieveAllVehicletypes();
		if(vehicletypes == null) {
			throw new BusinessException("No vehicle types found!");
		}
		return vehicletypes;
	}

	public VehicleType getvehicleTypeById(String vtypeid) throws BusinessException {
		// TODO Auto-generated method stub
		VehicleType vt = null;
		if(vtypeid.matches("[V]{1}[T]{1}[_]{1}[0-9]{5}"))
		{
			vt = vehicletypedao.getVehicleTypeByID(vtypeid);
		//return vt;
		}
		if(vt == null) {
			throw new BusinessException("No driver available");
		}
		return vt;	
			
	}

}
