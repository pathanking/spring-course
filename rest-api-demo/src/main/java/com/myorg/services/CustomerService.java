package com.myorg.services;

import java.util.List;

import com.myorg.entities.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);
	
	public Customer updateCustomer(Long cid, Customer customer);
	
	public void deleteCustomer(Long cid);
	
	public List<Customer> listCustomers();
	
	public Customer getOne(Long cid);
}
