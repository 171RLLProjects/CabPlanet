package com.mphasis.cab.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.cab.entities.Admin;
import com.mphasis.cab.entities.Booking;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.exceptions.BusinessException;
@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	public Admin adminlogin(String uname, String pass) throws BusinessException {
		Session session=sessionFactory.openSession();
		Admin admin=null;
		try {
		Criteria cr=session.createCriteria(Admin.class);
		Criterion username=Restrictions.eq("userName",uname);
		Criterion password=Restrictions.eq("pwd",pass);
		LogicalExpression andExpression=Restrictions.and(username, password);
		cr.add(andExpression);
		admin=(Admin) cr.uniqueResult();
		
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("admin dao login called");
	    	throw new BusinessException("Admin login failed");
	    }
		return admin;
	}

	public void addAdmin(Admin admin) throws BusinessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.save(admin);
		session.getTransaction().commit();
		}catch(Exception e) {
	    	throw new BusinessException("Admin record is not added");
	    }
		
	}

	public void deleteAdmin(String aid) throws BusinessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		try {
		Admin a=(Admin) session.get(Admin.class,aid);
		session.delete(a);
		session.getTransaction().commit();
		}
		catch(Exception e) {
	    	throw new BusinessException("requested admin is not present to delete");
	    }
		
	}

	public Admin getAdminById(String aid) throws BusinessException {
Session session=sessionFactory.openSession();
		try {
Admin a=(Admin) session.get(Admin.class,aid);
		
		return a;
		}catch(Exception e) {
	    	throw new BusinessException("requested Admin id is not present");
	    }
	}

	public Set<Admin> getAdmins() throws BusinessException {
		Session session=sessionFactory.openSession();
		try {
		List<Admin> admin=(List<Admin>) session.createCriteria(Admin.class).list();
		Set<Admin> a = new HashSet<Admin>(admin); 
		return a;
		}catch(Exception e) {
	    	throw new BusinessException("requested Admins are not present");
	    }
	}

	

}
