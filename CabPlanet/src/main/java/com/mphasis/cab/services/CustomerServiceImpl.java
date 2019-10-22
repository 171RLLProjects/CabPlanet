package com.mphasis.cab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.cab.daos.CustomerDao;
import com.mphasis.cab.entities.Customer;
import com.mphasis.cab.exceptions.BusinessException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	public Customer login(long phoneNumber, String pwd) throws BusinessException {
		Customer customer =null;
		/*try {
			customer=customerDao.login(phoneNumber, pwd);
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return customer;
	}*/
	if(pwd.matches("[A-Za-z0-9@_]{8,10}")) {
		customer=customerDao.login(phoneNumber, pwd);
	}else {
		throw new BusinessException("Invalid Password");
	}
	return customer;
	}
	public void registerCustomer(Customer customer) throws BusinessException {
		long contactnumber = customer.getPhoneNumber();
	    Long longInstance = new Long(contactnumber);
	    String connumber =  longInstance.toString();
		if(customer.getCid().matches("[a-zA-Z0-9_]+")) {
		if(customer.getCfname().matches("[A-Za-z]{3,20}")) {
			if(customer.getClname().matches("[A-Za-z]{3,20}")) {
			if (customer.getPwd().matches("[A-Za-z0-9@_]{8,10}")){
				if(customer.getEmail().matches("[A-Za-z.@0-9]{5,25}")) {
					if(connumber.matches("[0-9]{10}")) {
						if(customer.getPresentAddress().matches("[A-Za-z0-9,]{5,40}")) {
							if(customer.getPermanentAddress().matches("[A-Za-z0-9,]{5,40}")) {
								customerDao.registerCustomer(customer);
							}else {
								throw new BusinessException("Invalid Permanent Address");
							}							
						}else {
							throw new BusinessException("Invalid Present Address");
						}	
					}else {
						throw new BusinessException("Invalid Phone Number");
					}
					
				}else {
					throw new BusinessException("Invalid Email Id");
				}	
			}else {
				throw new BusinessException("Password was not as per instruction");
			}				
			}else {
				throw new BusinessException("Name should contain only alphabets");
			}
		}else {
			throw new BusinessException("Name should contain only alphabets");
		}	
		}else {
			throw new BusinessException("Id is invalid");
		}
	}

	public void updateCustomer(Customer customer)  throws BusinessException {
		long contactnumber = customer.getPhoneNumber();
	    Long longInstance = new Long(contactnumber);
	    String connumber =  longInstance.toString();
		if(customer.getCid().matches("[a-zA-Z0-9_]+")) {
		if(customer.getCfname().matches("[A-Za-z]{3,20}")) {
			if(customer.getClname().matches("[A-Za-z]{3,20}")) {
			if (customer.getPwd().matches("[A-Za-z0-9@_]{8,10}")){
				if(customer.getEmail().matches("[A-Za-z.@0-9]{5,25}")) {
					if(connumber.matches("[0-9]{10}")) {
						if(customer.getPresentAddress().matches("[A-Za-z0-9,]{5,40}")) {
							if(customer.getPermanentAddress().matches("[A-Za-z0-9,]{5,40}")) {
								customerDao.updateCustomer(customer);
							}else {
								throw new BusinessException("Invalid Permanent Address");
							}							
						}else {
							throw new BusinessException("Invalid Present Address");
						}	
					}else {
						throw new BusinessException("Invalid Phone Number");
					}
					
				}else {
					throw new BusinessException("Invalid Email Id");
				}	
			}else {
				throw new BusinessException("Password was not as per instruction");
			}				
			}else {
				throw new BusinessException("Name should contain only alphabets");
			}
		}else {
			throw new BusinessException("Name should contain only alphabets");
		}	
		}else {
			throw new BusinessException("Id is invalid");
		}
	}
	public void deleteCustomer(String cid)  throws BusinessException {
		 if(cid.matches("[a-zA-Z0-9_]+")) {
	            customerDao.deleteCustomer(cid);
	        }else {
	            throw new BusinessException("id does not match with the existing Customer");
	        }
	}

	public List<Customer> retirveAll()  throws BusinessException {
		 List<Customer> customers=null;
	        try {
	        	customers=customerDao.retirveAll();
	        }
	        catch (Exception e) {
	            throw new BusinessException("Customers are not available");
	        }
	        if(customers==null) {
	            throw new BusinessException("The requested Customers are not available");
	        }
	        return customers;
	}

	public Customer retriveCustomerById(String cid)  throws BusinessException {
		Customer customer = null;
		if(cid.matches("[a-zA-Z0-9_]{8}")) /*if(cid.contentEquals(customer.getCid()))*/{
		 customer=customerDao.retriveCustomerById(cid);
		}else {
            throw new BusinessException("The requested Customer not available");

		}      
		if(customer == null) {
			 throw new BusinessException("The requested Customer not available");
		}
        return customer;
	}
	
	public void updatePassword(String cid, String pwd) throws BusinessException {
		if(cid.matches("[a-zA-Z0-9_]+")) {
			customerDao.updatePassword(cid, pwd);
		}else {
			 throw new BusinessException("id does not match with the existing Customer");
		}
	}

}
