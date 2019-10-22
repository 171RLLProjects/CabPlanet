package com.mphasis.cab.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.cab.entities.Driver;
import com.mphasis.cab.entities.VehicleType;
import com.mphasis.cab.exceptions.BusinessException;

@Repository
public class VehicleTypeDaoImpl implements VehicleTypeDao{

	@Autowired	
	SessionFactory sessionFactory;
	
	public void addVehicleType(VehicleType vehicletype) throws BusinessException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.save(vehicletype);
		}catch(Exception e) {
			throw new BusinessException("vehicletype not present");
		}
		session.getTransaction().commit();
		session.close();
		
	}

	public void deleteVehicleType(String vtypeid) throws BusinessException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
		VehicleType vehicletype = (VehicleType)session.get(VehicleType.class,vtypeid);
		session.delete(vehicletype);
		}catch(Exception e) {
			throw new BusinessException("vtypeid not present");
		}
		session.getTransaction().commit();
		session.close();
		
	}

	public void updateVehicleType(VehicleType vehicletype) throws BusinessException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.saveOrUpdate(vehicletype);
		}catch(Exception e) {
			throw new BusinessException("vehicletype not present");
		}
		session.getTransaction().commit();
		session.close();
	}

	public List<VehicleType> retrieveAllVehicletypes() throws BusinessException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<VehicleType> vehicletypes=null;
		try {
		vehicletypes = session.createCriteria(VehicleType.class).list();
		}catch(Exception e) {
			throw new BusinessException("No VehicleTypes");
		}
		return vehicletypes;
	}


		/*Driver driver=null;
		if(did.matches("[D]{1}[R]{1}[_]{1}[0-9]{5}") && did!=null)
		{
			driver = driverDao.getDriverDetailsById(did);
		return driver;
		}
		if(driver == null) {
			throw new BusinessException("No driver available");
		}
		return driver;	*/

	public VehicleType getVehicleTypeByID(String vtypeid) throws BusinessException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		VehicleType vehiclety=null;
		try {
		vehiclety  = (VehicleType)session.get(VehicleType.class,vtypeid);
		}catch(Exception e) {
			throw new BusinessException("vtypeid not present");
		}
		return vehiclety;
	}

	public double getfarebyVehicleType(String vtype, int vseatcapacity) throws BusinessException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		VehicleType veh=null;
		try {
		Criteria cr = session.createCriteria(VehicleType.class);
		System.out.println(vtype+" data in dao "+vseatcapacity);
		Criterion vtype1 = Restrictions.eq("vType",vtype);
		Criterion vseatcapacity1 = Restrictions.eq("vSeatCapacity", vseatcapacity);
		LogicalExpression andExpression = Restrictions.and(vtype1,vseatcapacity1);
		cr.add(andExpression);
		veh = (VehicleType)cr.uniqueResult();
		}catch(Exception e) {
			throw new BusinessException("Invalid Details");
		}
		return veh.getFarePK();
		
	}
}


