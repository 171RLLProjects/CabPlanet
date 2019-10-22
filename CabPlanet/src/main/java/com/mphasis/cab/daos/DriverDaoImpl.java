package com.mphasis.cab.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.cab.entities.Booking;
import com.mphasis.cab.entities.Driver;
import com.mphasis.cab.exceptions.BusinessException;

@Repository
public class DriverDaoImpl implements DriverDao {


	@Autowired	
	SessionFactory sessionFactory;

	public Booking getBookingById(String bid) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Booking booking = (Booking)session.get(Booking.class,bid);
		
		return booking;
	}

	public void deleteBooking(String bid) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Booking booking=null;
		try {
			 booking  = (Booking)session.get(Booking.class,bid);
		}catch(Exception e) {
			throw new BusinessException("bid is not present");
		}
		
		session.delete(booking);
		session.close();

	}

	public void insertDriverDetails(Driver driver) throws BusinessException{
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.save(driver);
		}catch(Exception e) {
			throw new BusinessException("driver details not present");
		}
		session.getTransaction().commit();
		session.close();
	}

	public void updateDriverDetails(Driver driver) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.saveOrUpdate(driver);
		}catch(Exception e) {
			throw new BusinessException("driver details not present");
		}
		session.getTransaction().commit();
		session.close();

	}

	public void deleteDriverDetails(String did) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			Driver driver  = (Driver)session.get(Driver.class,did);
			session.delete(driver);
			
		}catch(Exception e) {
			throw new BusinessException("driver Id is not present");
		}
		
		session.getTransaction().commit();
		session.close();
		
	}

	public Driver getDriverDetailsById(String did) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Driver driver = null;
		try {
			driver  = (Driver)session.get(Driver.class, did);
			
		}catch(Exception e) {
			throw new BusinessException("driver Id is not present");
		}
	
		return driver;
	}

	public Driver loginDriver(String username, String password) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Driver driver = null;
		try {
		Criteria cr = session.createCriteria(Driver.class);
		System.out.println(username+" data in dao "+password);
		Criterion uname = Restrictions.eq("dname",username);
		Criterion pass = Restrictions.eq("pwd", password);
		LogicalExpression andExpression = Restrictions.and(uname,pass);
		cr.add(andExpression);
		driver = (Driver) cr.uniqueResult();
		}catch(Exception e) {
			throw new BusinessException("Invalid Credentials");
		}
		return driver;
		
		
		
	}

	public List<Driver> getAllDrivers() throws BusinessException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<Driver> drivers=null;
		try {
			drivers = session.createCriteria(Driver.class).list();
		}catch(Exception e) {
			throw new BusinessException("Drivers not presents");
		}
		
		return drivers;
	}

	public void updateDriverPassword(String did,String pwd) throws BusinessException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
		System.out.println(pwd);
		System.out.println(did);
		Query query = session.createQuery("update Driver set pwd = :pwd"+" where did= :did");
		query.setParameter("did",did);
		query.setParameter("pwd",pwd);
		
		query.executeUpdate();
		System.out.println(pwd);
		System.out.println(did);
		}catch(Exception e) {
			throw new BusinessException("Invalid Credentials");
		}
		session.getTransaction().commit();
		session.close();
		
		
	}

}
