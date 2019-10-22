package com.mphasis.cab.controller;

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

import com.mphasis.cab.entities.Vehicle;
import com.mphasis.cab.entities.VehicleType;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.services.VehicleService;

@RestController
public class VehicleDemoController {

	@Autowired
	VehicleService vehicleservice;
	
	

	// ADD VEHICLE DETAILS__________________________________________________________________________________________
	
		@RequestMapping(value="/vehicle",method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Void> registerVehicle(@RequestBody Vehicle vehicle)
		{
			
			try {
				vehicleservice.addVehicle(vehicle);
				return new  ResponseEntity<Void>(HttpStatus.OK);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace();
				return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
		}
			
	
	//UPDATE VEHICLE DETAILS___________________________________________________________________________________________
		
		@RequestMapping(value="/vehicleupdate",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Void> updateVehicle(@RequestBody Vehicle vehicle)
		{
			
			try {
				vehicleservice.changeVehicle(vehicle);
				return new  ResponseEntity<Void>(HttpStatus.OK);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace();
				return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
			
			
		}		
		
	//DELETE VEHICLE DETAILS______________________________________________________________________________________________
		
		@RequestMapping(value="/vehicledelete/{vid}",method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Void> deleteVehicleType(@PathVariable("vid") String vid)
		{
			
			try {
				vehicleservice.removeVehicle(vid);
				return new  ResponseEntity<Void>(HttpStatus.OK);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace();
				return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
			
			
		}

// GET VEHICLE DETAILS BY ID________________________________________________________________________________________________
		
		@RequestMapping(value="/vehicledetails/{vid}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Vehicle> getVehicleById(@PathVariable("vid")String vid)
		{
			Vehicle vh = null;
			try {
				vh = vehicleservice.showVehicleByID(vid);
				return new  ResponseEntity<Vehicle>(vh,HttpStatus.OK);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace();
				return new  ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
			}
			
		}
	
	
// GET VEHICLE DETAILS BY DRIVER ID________________________________________________________________________________________________
		
		@RequestMapping(value="/vehicledetailsdid/{did}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Vehicle> getVehicleByDriverId(@PathVariable("did")String did)
		{
			Vehicle vd = null;
				try {
					vd = vehicleservice.showVehicleByDriverId(did);
					return new  ResponseEntity<Vehicle>(vd,HttpStatus.OK);
					} catch (BusinessException e) {
						// TODO: handle exception
						e.printStackTrace();
						return new  ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
					}
					
				}		
	
// GET ALL VEHICLETYPES______________________________________________________________________________________________________________
		
				@RequestMapping(value="/vehicles/{vType}/{vSeatCapacity}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
				@ResponseBody
				public ResponseEntity<List<Vehicle>> getVehicles(@PathVariable("vType")String vtype,@PathVariable("vSeatCapacity")int vseatcapacity)
				{
					List<Vehicle> vehicles = null;
					try {
						vehicles = vehicleservice.showVehiclebyvehicleTypes(vtype, vseatcapacity);
						return new ResponseEntity<List<Vehicle>>(vehicles,HttpStatus.OK);
					} catch (BusinessException e) {
						// TODO: handle exception
						//e.printStackTrace();
						return new ResponseEntity<List<Vehicle>>(HttpStatus.NO_CONTENT);
					}
					
				}				
		
}
