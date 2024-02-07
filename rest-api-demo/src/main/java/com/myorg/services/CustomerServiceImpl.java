package com.myorg.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myorg.entities.Customer;
import com.myorg.exceptions.CustomerNotFoundException;
import com.myorg.repos.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository repository;

	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer updateCustomer(Long cid, Customer customer) {
		Customer cust = getOne(cid);
		cust.setName(customer.getName());
		cust.setEmail(customer.getEmail());
		cust.setAddress(customer.getAddress());
		return repository.save(cust);
	}

	@Override
	public void deleteCustomer(Long cid) {
		Customer customer = getOne(cid);
		repository.delete(customer);
	}

	@Override
	public List<Customer> listCustomers() {
		return repository.findAll();
	}

	@Override
	public Customer getOne(Long cid) {
		return repository.findById(cid)
				.orElseThrow(() -> new CustomerNotFoundException("Customer having ID " + cid + " Not Found!"));
	}
}
