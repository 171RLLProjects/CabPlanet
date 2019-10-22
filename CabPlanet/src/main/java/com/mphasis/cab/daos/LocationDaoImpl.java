package com.mphasis.cab.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.cab.entities.Admin;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.exceptions.BusinessException;
@Repository
public class LocationDaoImpl implements LocationDao {

	
	@Autowired
	SessionFactory sessionFactory;
	public void addLocation(Location location) throws BusinessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.save(location);
		session.getTransaction().commit();
		}catch(Exception e) {
	    	throw new BusinessException("Location was not added");
	    }
		
	}

	public void updateLocation(Location location) throws BusinessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.saveOrUpdate(location);
		session.getTransaction().commit();
		}catch(Exception e) {
	    	throw new BusinessException("requested Location is not updated");
	    }
		
	}

	public void deleteLocation(String lid) throws BusinessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
	    try {
		Location l=(Location) session.get(Location.class,lid);
		session.delete(l);
		session.getTransaction().commit();
	    }catch(Exception e) {
	    	throw new BusinessException("requested id is not present");
	    }
		
		
	}

	public Location getLocationById(String lid) throws BusinessException {
		Session session=sessionFactory.openSession();
		try {
		Location l=(Location) session.get(Location.class,lid);
		return l;
		}catch(Exception e) {
	    	throw new BusinessException("requested Location id is not present");
	    }
		
		
	}

	public Set<Location> getLocations() throws BusinessException {
		Session session=sessionFactory.openSession();
		try {
		List<Location> locs=session.createCriteria(Location.class).list();
		Set<Location> locations = new HashSet<Location>(); 
		locations.addAll(locs);
		return locations;
				}catch(Exception e) {
			    	throw new BusinessException("requested Locations are not present");
			    }
	
	}

	public Location getLocationByName(String lname) throws BusinessException {
		Session session=sessionFactory.openSession();
		try {
		Criteria cr=session.createCriteria(Location.class);
		cr.add(Restrictions.eq("lname",lname));
	Location l=(Location) cr.uniqueResult();
		return l;
		}catch(Exception e) {
	    	throw new BusinessException("requested Location name is not present");
	    }
	}

}
