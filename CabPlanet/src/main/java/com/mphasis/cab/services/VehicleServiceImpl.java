package com.mphasis.cab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.cab.daos.VehicleDao;
import com.mphasis.cab.entities.Vehicle;
import com.mphasis.cab.entities.VehicleType;
import com.mphasis.cab.exceptions.BusinessException;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDao vehicledao;
	
	public void addVehicle(Vehicle vehicle) throws BusinessException{
		// TODO Auto-generated method stub
		
		if(vehicle.getvName().matches("[A-Za-z]{3,20}")) 
		{
			if(vehicle.getVnumber().matches("[A-Z]{2}[0-9]{2}[0-9]{4}"))
			{
				vehicledao.insertVehicle(vehicle);
			}else throw new BusinessException("Not a valid vehicle number");
		}else throw new BusinessException("Not a valid vehicle name!");

	}

	public void changeVehicle(Vehicle vehicle) throws BusinessException {
		// TODO Auto-generated method stub
		if(vehicle.getvName().matches("[A-Za-z]{3,20}")) 
		{
			if(vehicle.getVnumber().matches("[A-Z]{2}[0-9]{2}[0-9]{4}"))
			{
		vehicledao.updateVehicle(vehicle);
			}else throw new BusinessException("Not a valid vehicle number");
		}else throw new BusinessException("Not a valid vehicle name!");
	}

	public void removeVehicle(String vid) throws BusinessException{
		// TODO Auto-generated method stub
		if(vid.matches("[V]{1}[E]{1}[_]{1}[0-9]{5}"))
		{
		vehicledao.deleteVehicle(vid);
		}else throw new BusinessException("Not a valid vehicle id");
	}

	public List<Vehicle> showVehiclebyvehicleTypes(String vtype, int vseatcapacity) throws BusinessException{
		// TODO Auto-generated method stub
		List<Vehicle> vehicles=null;
		vehicles = vehicledao.getVehiclebyvehicleTypes(vtype, vseatcapacity);
		if(vehicles == null) {
			throw new BusinessException("No vehicletypes present");
		}
		return vehicles;
	}

	public Vehicle showVehicleByID(String vid) throws BusinessException{
		// TODO Auto-generated method stub
		Vehicle v = null;
		if(vid.matches("[V]{1}[E]{1}[_]{1}[0-9]{5}"))
		{
			v = vehicledao.getVehicleByID(vid);
		//return v;
		}
		if(v == null)
		{
			throw new BusinessException("No driver id available");
		}
		return v;
	}

	public Vehicle showVehicleByDriverId(String did) throws BusinessException{
		// TODO Auto-generated method stub
		Vehicle vh = null;
		if(did.matches("[D]{1}[R]{1}[_]{1}[0-9]{5}"))
		{
			vh = vehicledao.getVehicleByDriverId(did);
		//return vh;
		}
		if(vh == null)
		{
			throw new BusinessException("No driver id available");
		}
		return vh;
		
	}

}
	
