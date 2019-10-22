package com.mphasis.cab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.cab.daos.RouteDao;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.entities.Route;
import com.mphasis.cab.exceptions.BusinessException;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	RouteDao routeDao;
	public void addRoute(Route route) throws BusinessException {
		
		if(route.getDistance()>=1) {
			routeDao.addRoute(route);
		}else throw new BusinessException("Distance must be greatger than 1km");
			
	}
	

	public Route getRouteByRid(String rid) throws BusinessException {
		Route route=null;
		if(rid.matches("[R]{1}[O]{1}[_]{1}[0-9]{5}")) {
		route=routeDao.getRouteByRid(rid);
		
		}else {throw new BusinessException("rid is not in format");}
		if(route==null) {
			throw new BusinessException("No route");
		}
		return route;

		

	}

	public double getDistanceByRid(String rid) throws BusinessException {
		double distance=0.0;
		if(rid.matches("[R]{1}[O]{1}[_]{1}[0-9]{5}")) {
		Route route=routeDao.getRouteByRid(rid);
		 distance=route.getDistance();
		}else throw new BusinessException("rid is not in format");
		return distance;
	}

	public Location getMiddlePointByRid(String rid) throws BusinessException {
		Location middlepoint=null;
		Route route=null;
		if(rid.matches("[R]{1}[O]{1}[_]{1}[0-9]{5}")) {
		route=routeDao.getRouteByRid(rid);
		
		 middlepoint=route.getMiddlePoint();
		}else {throw new BusinessException("rid is not in format");}
		
		if(middlepoint==null) {
			throw new BusinessException("No middle point");
		}
		return middlepoint;
	}

	public List<Route> getRoute() throws BusinessException {
		List<Route> routes=null;
		
		routes = routeDao.getRoute();
		if(routes==null) {
			throw new BusinessException("No routes present");
		}
		return routes;
	}

}
