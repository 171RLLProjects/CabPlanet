package com.mphasis.cab.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.cab.daos.AdminDao;
import com.mphasis.cab.daos.LocationDao;
import com.mphasis.cab.entities.Admin;
import com.mphasis.cab.entities.Location;
import com.mphasis.cab.exceptions.BusinessException;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public Admin adminlogin(String uname, String pass) throws BusinessException {
		Admin admin=null;

		
			if(uname.matches("[A-Za-z]{8,15}")) {
				if(pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
							admin=adminDao.adminlogin(uname, pass);
							
						}else {throw new BusinessException("Admin password doesnt match");}
		}else {throw new BusinessException("Admin username doesnt match");}
			if(admin==null) {
				throw new BusinessException("Admin username doesnt match");
			}
			return admin;
	}
		

	public void addAdmin(Admin admin) throws BusinessException {
		if(admin.getAid().startsWith("AD_")&&admin.getAid().length()==8) {
			if(admin.getUserName().matches("[A-Za-z]{8,15}")) {
				if(admin.getPwd().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
							adminDao.addAdmin(admin);
						
			}else {
				throw new BusinessException("Admin password doesnt match");}
				
			}
		else {
			throw new BusinessException("Admin username doesnt match");}
		}
			else {
				throw new BusinessException("Admin id doesnt match");}
	
		
	}

	public void deleteAdmin(String aid) throws BusinessException {
	
		if(aid.startsWith("AD_") && aid.length()==8) {
			adminDao.deleteAdmin(aid);
		}else {
			throw new BusinessException("id does not match with the existing admin one");
		}
		
	}

	public Admin getAdminById(String aid) throws BusinessException {
		Admin admin=null;
		try {
		admin = adminDao.getAdminById(aid);
		}catch (Exception e) {
			throw new BusinessException("Admin id doesnot exists in table");
		}
		if(admin==null) {
			throw new BusinessException("The requested Admin not available");
		}
		return admin;
	}

	public Set<Admin> getAdmins() throws BusinessException {
		Set<Admin> admin=null;
		try {
				admin=adminDao.getAdmins();
		}
		catch (Exception e) {
			throw new BusinessException("Admins are not available");
		}
		if(admin==null) {
			throw new BusinessException("The requested Admins not available");
		}
		return admin; 
	}

	
	
	
	

	
}
