package com.mphasis.cab.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.mphasis.cab.entities.Location;
import com.mphasis.cab.entities.Route;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.services.RouteService;

@RestController
public class RouteController {

	@Autowired
	RouteService routeService;
	
	@RequestMapping(value="/route/{rid}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Route> getRouteById(@PathVariable("rid")String rid){
		
		Route route=null;
		
		try {
			route = routeService.getRouteByRid(rid);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return new ResponseEntity<Route>(route,HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.accepted().body(route);
		
	}
	@RequestMapping(value="/route", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Route>> getRoute(){
		
		List<Route> route=null;
		
		try {
			route=routeService.getRoute();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return new ResponseEntity<List<Route>>(HttpStatus.SEE_OTHER);
		}
		return ResponseEntity.accepted().body(route);
		
	}
	@RequestMapping(value="/route", method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>> addRoute(@RequestBody Route route){
		Map<String,String> map=new HashMap<String,String>();
		try {
		
			routeService.addRoute(route);
			map.put("ok","Success Saving Route Details");
			return ResponseEntity.accepted().body(map);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
		
	}
	
	
	@RequestMapping(value="/routedistance/{rid}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  ResponseEntity<Double> getDistanceByRid(@PathVariable("rid")String rid){
		
		double distance=0.0;
		
		try {
			distance = routeService.getDistanceByRid(rid);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(distance);
			
		}
		return ResponseEntity.accepted().body(distance);
		
	}
	@RequestMapping(value="/routemiddlepoint/{rid}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Location> getMiddleByRid(@PathVariable("rid")String rid){
		
		Location middlepoint=null;
		try {
			middlepoint = routeService.getMiddlePointByRid(rid);
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//   System.out.println("catch");
			return new ResponseEntity<Location>(middlepoint,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Location>(middlepoint,HttpStatus.OK);
		
	}
	
	
}
