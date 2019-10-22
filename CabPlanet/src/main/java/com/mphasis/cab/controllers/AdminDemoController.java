package com.mphasis.cab.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

import com.mphasis.cab.entities.Admin;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.services.AdminService;
import com.mphasis.cab.services.LocationService;

@RestController
public class AdminDemoController {
	@Autowired
	AdminService adminService;
	@Autowired
	LocationService locationService;
	@RequestMapping(value="/admin",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>> addAdmin(@RequestBody Admin admin)
	{
		Map<String,String> map=new HashMap<String, String>();
		try {
			adminService.addAdmin(admin);
			map.put("ok","Sucess Saving Admin Details");
			return ResponseEntity.accepted().body(map);
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@RequestMapping(value="/adminlogin/{uname}/{pass}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Admin> login(@PathVariable("uname")String uname,@PathVariable("pass")String pass)
	{
		Admin admin=null;
		try {
			admin=adminService.adminlogin(uname, pass);
			//System.out.println(admin.getPwd());
		} catch (BusinessException e) {
			System.out.println("catch calling");
			//e.printStackTrace();
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.accepted().body(admin);
	}
	
	@RequestMapping(value="/admin/{aid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>> deleteAdmin(@PathVariable("aid")String aid)
	{
		Map<String,String> map=new HashMap<String, String>();
		try {
			adminService.deleteAdmin(aid);
			map.put("ok","Sucess Saving Admin Details");
			return ResponseEntity.accepted().body(map);
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
	}
	@RequestMapping(value="/adminid/{aid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Admin> getAdminById(@PathVariable("aid") String aid) {
		Admin admin=null;
		try {
			admin=adminService.getAdminById(aid);
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return new ResponseEntity<Admin>(HttpStatus.SEE_OTHER);
		}
		return ResponseEntity.accepted().body(admin);
	}
	
	@RequestMapping(value="/adminget",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Admin>> getAdmins(){
		Set<Admin> admin=null;
		
		try {
			admin=adminService.getAdmins();
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return new ResponseEntity<Set<Admin>>(HttpStatus.SEE_OTHER);
		}
		return ResponseEntity.accepted().body(admin);	
	}
	
	
	
	
	
	@RequestMapping(value="/location",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>> addLocation(@RequestBody Location location)
	{
		Map<String,String> map=new HashMap<String, String>();
		try {
			locationService.addLocation(location);
			map.put("ok","Sucess Saving Location");
			return ResponseEntity.accepted().body(map);
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
		
	}
	@RequestMapping(value="/locationu",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>> updatelocation(@RequestBody Location location)
	{
		Map<String,String> map=new HashMap<String, String>();
		try {
			locationService.updateLocation(location);
			map.put("ok","Sucess Updating Location");
			return ResponseEntity.accepted().body(map);
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
		
	}
	@RequestMapping(value="/location/{lid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>> deleteLocation(@PathVariable("lid")String lid)
	{
		Map<String,String> map=new HashMap<String, String>();
		try {
			locationService.deleteLocation(lid);
			map.put("ok","Sucess Deleting Location");
			return ResponseEntity.accepted().body(map);
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
	}

	@RequestMapping(value="/locationid/{lid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Location> getLocationById(@PathVariable("lid")String lid)
	{
		Location l=null;
		try {
			l=locationService.getLocationById(lid);
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return new ResponseEntity<Location>(HttpStatus.SEE_OTHER);
		}
		return ResponseEntity.accepted().body(l);
		
	}
	@RequestMapping(value="/locationget",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
	public ResponseEntity<Set<Location>> getLocations(){
		Set<Location> loc=null;
		
		try {
			loc=locationService.getLocations();
			
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return new ResponseEntity<Set<Location>>(HttpStatus.SEE_OTHER);
		}
		
		return ResponseEntity.accepted().body(loc);
		
	}
	@RequestMapping(value="/locationun/{uname}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Location> getLocationByName(@PathVariable("uname")String uname){
		Location loc=null;
		try {
			loc=(Location) locationService.getLocationByName(uname);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Location>(HttpStatus.SEE_OTHER);
		}
		
		return ResponseEntity.accepted().body(loc);
		
	}

	
}
