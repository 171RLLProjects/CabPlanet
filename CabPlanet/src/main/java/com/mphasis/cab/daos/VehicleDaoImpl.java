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


import com.mphasis.cab.entities.Vehicle;
import com.mphasis.cab.entities.VehicleType;
import com.mphasis.cab.exceptions.BusinessException;


@Repository
public class VehicleDaoImpl implements VehicleDao  {

	@Autowired	
	SessionFactory sessionFactory;
	
	public void insertVehicle(Vehicle vehicle) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.save(vehicle);
		}catch(Exception e) {
			throw new BusinessException("vehicle details not present");
		}
		
		session.getTransaction().commit();
		session.close();
	}

	public void updateVehicle(Vehicle vehicle) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.saveOrUpdate(vehicle);
		}catch(Exception e) {
			throw new BusinessException("vehicle details not present");
		}
		session.getTransaction().commit();
		session.close();
	}

	public void deleteVehicle(String vid) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			Vehicle vehicle = (Vehicle)session.get(Vehicle.class,vid);
			session.delete(vehicle);
		}catch(Exception e) {
			throw new BusinessException("Vehicle is not present");
		}
		
		session.getTransaction().commit();
		session.close();

	}

	public List<Vehicle> getVehiclebyvehicleTypes(String vtype, int vseatcapacity) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		 List<Vehicle> vehicles=null;
		try {
		Criteria cr = session.createCriteria(VehicleType.class);
		System.out.println(vtype+" data in dao "+vseatcapacity);
		Criterion vtype1 = Restrictions.eq("vType",vtype);
		Criterion vseatcapacity1 = Restrictions.eq("vSeatCapacity", vseatcapacity);
		LogicalExpression andExpression = Restrictions.and(vtype1,vseatcapacity1);
		cr.add(andExpression);
		VehicleType veh = (VehicleType) cr.uniqueResult();
	    Criteria cr1 = session.createCriteria(Vehicle.class);
	    vehicles =  cr1.add(Restrictions.eq("vehicleType", veh)).list();
		}catch(Exception e) {
			throw new BusinessException("Invalid Details");
		}
		return vehicles;
	}
	
	/*
	public List<Admin> getAdminByType(String type) {
	     // TODO Auto-generated method stub
	     Session session=sessionFactory.openSession();
	     List<Admin> admins=session.createCriteria(Admin.class).add(Restrictions.eq("type", type)).list();
	     return admins;
	 }*/
	

	public Vehicle getVehicleByID(String vid) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Vehicle vehi=null;
		try {
		vehi  = (Vehicle)session.get(Vehicle.class,vid);
		}catch(Exception e) {
			throw new BusinessException("vehicle id is not present");
		}
		return vehi;
	}

	public Vehicle getVehicleByDriverId(String did) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Vehicle vehd=null;
		try {
		vehd  = (Vehicle)session.get(Vehicle.class,did);
		}catch(Exception e) {
			throw new BusinessException("driver id is not present");
		}
		return vehd;
	}

}
