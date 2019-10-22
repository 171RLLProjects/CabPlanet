package com.mphasis.cab.services;

import java.util.Set;

import com.mphasis.cab.entities.Admin;
import com.mphasis.cab.exceptions.BusinessException;

public interface AdminService {
	public Admin adminlogin(String uname,String pass) throws BusinessException;
	public void addAdmin(Admin admin)throws BusinessException;
	public void deleteAdmin(String aid)throws BusinessException;
	public Admin getAdminById(String aid)throws BusinessException;
	public Set<Admin> getAdmins()throws BusinessException;
	
}
