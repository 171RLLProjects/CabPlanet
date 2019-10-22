package com.mphasis.cab.daos;

import java.util.List;

import com.mphasis.cab.entities.Route;
import com.mphasis.cab.exceptions.BusinessException;

public interface RouteDao {

	public void addRoute(Route route)throws BusinessException;

	public Route getRouteByRid(String rid)throws BusinessException;
	public List<Route> getRoute() throws BusinessException;
	
	
}
