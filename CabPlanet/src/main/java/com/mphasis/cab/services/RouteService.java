package com.mphasis.cab.services;

import java.util.List;

import com.mphasis.cab.entities.Location;
import com.mphasis.cab.entities.Route;
import com.mphasis.cab.exceptions.BusinessException;

public interface RouteService {

	public void addRoute(Route route)throws BusinessException;
	
	public Route getRouteByRid(String rid)throws BusinessException;
	public double getDistanceByRid(String rid)throws BusinessException;
	public Location getMiddlePointByRid(String rid)throws BusinessException;
	public List<Route> getRoute() throws BusinessException;
}
