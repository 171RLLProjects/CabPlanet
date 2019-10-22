package com.mphasis.cab.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.cab.entities.Customer;
import com.mphasis.cab.exceptions.BusinessException;

@Repository
public class CustomerDaoImpl implements CustomerDao {


	@Autowired
	SessionFactory sessionFactory;

	public Customer login(long phoneNumber, String pwd) throws BusinessException {
		System.out.println("before login called ");
		Session session=sessionFactory.openSession();
		Customer customer=null;
		try {
			Criteria cr=session.createCriteria(Customer.class);
			Criterion phnNum=Restrictions.eq("phoneNumber",  phoneNumber);
			Criterion password=Restrictions.eq("pwd",pwd);
			LogicalExpression andExpression =
					Restrictions.and(phnNum,password);
			cr.add(andExpression);
			customer=(Customer) cr.uniqueResult();
			System.out.println("login called after");
		}catch (Exception e) {
			throw new BusinessException("Invalid credentials");
		}
		return customer;
	}

	public void registerCustomer(Customer customer) throws BusinessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(customer);
			session.getTransaction().commit();
			session.close();
		}catch (Exception e) {
			throw new BusinessException("Registration Failed");
		}

	}

	public void updateCustomer(Customer customer) throws BusinessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.update(customer);
			session.getTransaction().commit();
		}catch (Exception e) {
			throw new BusinessException("Unable to update customer details" );
		}


	}

	public void deleteCustomer(String cid) throws BusinessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		try {
			Customer customer=(Customer)session.get(Customer.class, cid);
			session.delete(customer);
			session.getTransaction().commit();
		}catch (Exception e) {
			throw new BusinessException("Unable to delete customer" );
		}


	}

	public List<Customer> retirveAll()  throws BusinessException{
		Session session=sessionFactory.openSession();
		List<Customer> customers=null;
		try {
			customers=session.createCriteria(Customer.class).list();
		}catch (Exception e) {
			throw new BusinessException("No customers are available" );
		}
		return customers;
	}

	public Customer retriveCustomerById(String cid) throws BusinessException {
		Session session=sessionFactory.openSession();
		Customer customer=null;
		try {
			customer=(Customer)session.get(Customer.class, cid);
		}catch (Exception e) {
			throw new BusinessException("Cannot retrive customer details because customer id is not present" );
		}
		return customer;

	}

	public void updatePassword(String cid, String pwd) throws BusinessException{

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			System.out.println(pwd);
			System.out.println(cid);
			Query query = session.createQuery("update Customer set pwd = :pwd"+" where cid= :cid");
			query.setParameter("cid",cid);
			query.setParameter("pwd",pwd);
			query.executeUpdate();
			System.out.println(pwd);
			System.out.println(cid);
			session.getTransaction().commit();
			session.close();
		}catch (Exception e) {
			throw new BusinessException("Cannot update password");
		}

	}

}
