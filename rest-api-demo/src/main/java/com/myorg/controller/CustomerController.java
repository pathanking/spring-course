package com.myorg.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.entities.Customer;
import com.myorg.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers/v1/api")
public class CustomerController {

	private CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping("/list")
	public List<Customer> customers() {
		return service.listCustomers();
	}

	@PostMapping("/save")
	public Customer add(@Valid @RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}

	@GetMapping("/getone/{cid}")
	public Customer findOne(@PathVariable Long cid) {
		return service.getOne(cid);
	}

	@PutMapping("/update/{cid}")
	public Customer update(@PathVariable Long cid, @Valid @RequestBody Customer customer) {
		return service.updateCustomer(cid, customer);
	}

	@DeleteMapping("/delete/{cid}")
	public String delete(@PathVariable Long cid) {
		service.deleteCustomer(cid);
		return "Customer Record Deleted Successfully!";
	}
}
