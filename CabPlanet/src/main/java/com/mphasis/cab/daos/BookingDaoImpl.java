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
import com.mphasis.cab.entities.Customer;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.entities.Route;
import com.mphasis.cab.entities.Vehicle;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.util.Status;
@Repository
public class BookingDaoImpl implements BookingDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addBooking(Booking booking) throws BusinessException{
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(booking);
			session.getTransaction().commit();
		}catch(Exception e) {
			throw new BusinessException("requested booking is not present"); 
		}

		session.close();
	}

	public void updateBooking(Booking booking) throws BusinessException{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(booking);
			session.getTransaction().commit();
		}catch(Exception e) {
			throw new BusinessException("requested booking is not present");
		}
		session.close();
	}




	public List<Booking> getAll()throws BusinessException {
		Session session = sessionFactory.openSession();
		List<Booking> bookings=null;
		try {
			bookings= session.createCriteria(Booking.class).list();
		}catch(Exception e) {
			throw new BusinessException("No bookings");
		}
		return bookings;
	}

	public Booking getBookingById(String bid)throws BusinessException 

	{

		Session session = sessionFactory.openSession();
		Booking booking=null;
		System.out.println(bid);
		try {

			booking=session.get(Booking.class, bid);

		}catch(Exception e) {
			// e.printStackTrace();
			throw new BusinessException("requested bid is not present");
		}
		return booking;
	}

	public List<Booking> getBookingByLocation(Location source,Location destination) throws BusinessException {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria cr=session.createCriteria(Booking.class);
		
		Criteria cr2=session.createCriteria(Route.class);
		List<Route> routes=null;
		List<Booking> bookings=null;
		   Criterion source1 = Restrictions.eq("source",source);
	        Criterion destination1 = Restrictions.eq("destination", destination);
	        LogicalExpression andExpression = Restrictions.and(source1,destination1);
	        cr2.add(andExpression);
	         routes = cr2.list();
	        
	         for(Route route:routes )
			{
				
				cr.add(Restrictions.eq("route", route));

			}
			bookings=cr.list();
		

		return bookings;

	}	


	public void updateStatus(String bid,Status status) throws BusinessException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {

			Query query = session.createQuery("update Booking set status = :status"+" where bid= :bid");
			query.setParameter("bid",bid);
			query.setParameter("status",status);

			query.executeUpdate();
		}catch(Exception e) {
			//e.printStackTrace();
			throw new BusinessException("Invalid Details");
		}
		session.getTransaction().commit();
		session.close();

	}

	public List<Booking> getBookingByCustomer(String cid) throws BusinessException {

		List<Booking> bookings=null;
		Customer customer=null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			customer = (Customer) session.get(Customer.class, cid);
			bookings= session.createCriteria(Booking.class).add(Restrictions.eq("customer",customer)).list();
		}catch (Exception e) {
			throw new BusinessException("Invalid Details");
		}	
		
		return bookings;

	}




	public List<Booking> getBookingByVehicle(String vid) throws BusinessException {

		List<Booking> bookings=null;

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			Vehicle v = (Vehicle) session.get(Vehicle.class, vid);
			bookings= session.createCriteria(Booking.class).add(Restrictions.eq("vehicle",v)).list();
		}catch (Exception e) {
			throw new BusinessException("Invalid Details");
		}
		return bookings;
	}

	public List<Booking> getBookingByRoute(String rid) throws BusinessException{
		// TODO Auto-generated method stub
		List<Booking> bookings=null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			Route r = (Route) session.get(Route.class, rid);
			bookings= session.createCriteria(Booking.class).add(Restrictions.eq("route",r)).list();
		}catch (Exception e) {
			throw new BusinessException("Invalid Details");
		}
		return bookings;
	}



}
