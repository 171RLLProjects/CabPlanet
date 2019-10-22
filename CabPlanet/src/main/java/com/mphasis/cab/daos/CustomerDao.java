package com.mphasis.cab.daos;

import java.util.List;

import com.mphasis.cab.entities.Customer;
import com.mphasis.cab.exceptions.BusinessException;

public interface CustomerDao {

	public Customer login(long phoneNumber,String pwd) throws BusinessException;
	public void registerCustomer(Customer customer) throws BusinessException;
	public void updateCustomer(Customer customer) throws BusinessException;
	public void deleteCustomer(String cid) throws BusinessException;
	public List<Customer> retirveAll() throws BusinessException;
	public Customer retriveCustomerById(String cid) throws BusinessException;
	public void updatePassword(String cid, String pwd) throws BusinessException;


}
