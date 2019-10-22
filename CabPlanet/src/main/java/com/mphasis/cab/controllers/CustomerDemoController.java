package com.mphasis.cab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.cab.entities.Customer;
import com.mphasis.cab.exceptions.BusinessException;
import com.mphasis.cab.services.CustomerService;

@RestController
public class CustomerDemoController {

	@Autowired
	CustomerService customerService;

	//LOGIN
	@RequestMapping(value="/login/{phoneNumber}/{pwd}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> login(@PathVariable("phoneNumber") Long phoneNumber,@PathVariable("pwd") String pwd) {
		Customer customer = null;
		try {
			customer = customerService.login(phoneNumber, pwd);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} catch (BusinessException e) {
			e.printStackTrace();
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}
	}

	//REGISTERING CUSTOMER
	@RequestMapping(value="/customer", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
		try {
			customerService.registerCustomer(customer);
		} catch (BusinessException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	//UPDATING CUSTOMER
	@RequestMapping(value="/customer", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer) {
		try {
			customerService.updateCustomer(customer);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	//DELETING CUSTOMER
	@RequestMapping(value="/delete/{cid}", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteCustomer(@PathVariable ("cid") String cid)  {
		try {
			customerService.deleteCustomer(cid);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	//LIST OF CUSTOMERS
	@RequestMapping(value="/customer",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomer() {
		List<Customer> customers=null;
		try {
			customers=customerService.retirveAll();
			return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
	}

	//GETTING CUSTOMER DETAILS BY CUSTOMER ID
	@RequestMapping(value="/customer/{cid}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerById(@PathVariable ("cid") String cid) throws BusinessException {
		Customer customer;
		try {
			customer=customerService.retriveCustomerById(cid);
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);	
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}	
	}

	//UPDATING PASSWORD
	@RequestMapping(value="/password/{cid}/{pwd}", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updatePassword(@PathVariable ("cid") String cid,@PathVariable ("pwd") String pwd)  {
		try {
			customerService.updatePassword(cid, pwd);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
