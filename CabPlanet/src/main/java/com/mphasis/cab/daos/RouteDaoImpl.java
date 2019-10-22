package com.mphasis.cab.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.cab.entities.Route;
import com.mphasis.cab.exceptions.BusinessException;

@Repository
public class RouteDaoImpl implements RouteDao {

	@Autowired
	SessionFactory sessionFactory;
	public void addRoute(Route route) throws BusinessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(route);
		}catch(Exception e) {
			throw new BusinessException("route is not present");
		}
		
		session.getTransaction().commit();

	}

	

	public Route getRouteByRid(String rid) throws BusinessException {
		Session session=sessionFactory.openSession();
		Route route=null;
		try {
			 route=session.get(Route.class,rid);
			 System.out.println("distance"+route.getDistance());
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("route is not present");
		}
	    System.out.println(route.getDistance());
		return route;
		
	}
	
	public List<Route> getRoute() throws BusinessException {
		Session session=sessionFactory.openSession();
		List<Route> route=null;
		try {
			route=session.createCriteria(Route.class).list();
		}catch(Exception e) {
			throw new BusinessException("route is not present");
		}
	
		return route;
		
	}
	

}
