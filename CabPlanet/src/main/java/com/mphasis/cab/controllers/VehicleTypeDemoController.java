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

import com.mphasis.cab.entities.VehicleType;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.services.VehicleTypeService;

@RestController
public class VehicleTypeDemoController {

	@Autowired
	VehicleTypeService vehicletypeservice;
	
	// ADD VEHICLETYPE DETAILS__________________________________________________________________________________________
	
		@RequestMapping(value="/vehicletype",method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Void> registerVehicleType(@RequestBody VehicleType vehicletype)
		{
			
			try {
				vehicletypeservice.insertvehicleType(vehicletype);
				return new  ResponseEntity<Void>(HttpStatus.OK);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace(); 
				return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
			
			
		}
			
	
	//UPDATE VEHICLETYPE DETAILS___________________________________________________________________________________________
		
		@RequestMapping(value="/vehicletypeupdate",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Void> updateVehicleType(@RequestBody VehicleType vehicletype)
		{
			
			try {
				vehicletypeservice.changeVehicleType(vehicletype);
				return new  ResponseEntity<Void>(HttpStatus.OK);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace();
				return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
				
			}
			
			
		}		
		
	//DELETE VEHICLETYPE DETAILS______________________________________________________________________________________________
		
		@RequestMapping(value="/vehicletypedelete/{vtypeid}",method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Void> deleteVehicleType(@PathVariable("vtypeid") String vtypeid)
		{
			
			try {
				vehicletypeservice.removeVehicleType(vtypeid);
				return new  ResponseEntity<Void>(HttpStatus.OK);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace();
				return new  ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
			
			
		}

// GET VEHICLETYPE DETAILS BY ID________________________________________________________________________________________________
		
		@RequestMapping(value="/vehicletypedetails/{vtypeid}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<VehicleType> getVehicleTypeById(@PathVariable("vtypeid")String vtypeid)
		{
			VehicleType vt = null;
			try {
				vt = vehicletypeservice.getvehicleTypeById(vtypeid);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace();
				return new  ResponseEntity<VehicleType>(HttpStatus.BAD_REQUEST);
			}
			return new  ResponseEntity<VehicleType>(vt,HttpStatus.OK);
			
		}
		
// GET ALL VEHICLETYPES
		
		@RequestMapping(value="/vegtypes",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<List<VehicleType>> getVehicleTypes()
		{
			List<VehicleType> vehicletypes = null;
			try {
				vehicletypes = vehicletypeservice.getallVehicletypes();
				return new ResponseEntity<List<VehicleType>>(vehicletypes,HttpStatus.OK);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace();
				return new ResponseEntity<List<VehicleType>>(HttpStatus.NO_CONTENT);
			}

			
		}		
		
//GET FARE BY VEHCILETYPE____________________________________________________________________________________________________
		
		@RequestMapping(value="/faretype/{vType}/{vSeatCapacity}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Double> getFareByVehicleType(@PathVariable("vType")String vtype,@PathVariable("vSeatCapacity")int vseatcapacity)
		{
			double fare  = 0.0;
			try {
				fare = vehicletypeservice.viewfareByVehicleTypeID(vtype, vseatcapacity);
				return new ResponseEntity<Double>(fare,HttpStatus.OK);
			} catch (BusinessException e) {
				// TODO: handle exception
				//e.printStackTrace();
				return new ResponseEntity<Double>(HttpStatus.BAD_REQUEST);
			}
			
			
		}
		
		
		
}
