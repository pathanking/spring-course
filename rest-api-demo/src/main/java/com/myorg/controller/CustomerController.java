package com.myorg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<List<Customer>> customers() {
		return new ResponseEntity<List<Customer>>(service.listCustomers(), HttpStatus.OK) ;
	}

	@PostMapping("/save")
	public ResponseEntity<Customer> add(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(service.saveCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping("/getone/{cid}")
	public ResponseEntity<Customer> findOne(@PathVariable Long cid) {
		return new ResponseEntity<Customer>(service.getOne(cid), HttpStatus.OK); 
	}

	@PutMapping("/update/{cid}")
	public ResponseEntity<Customer> update(@PathVariable Long cid, @Valid @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(service.updateCustomer(cid, customer), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<String> delete(@PathVariable Long cid) {
		service.deleteCustomer(cid);
		return new ResponseEntity<String>("Customer Record Deleted Successfully!", HttpStatus.ACCEPTED);
	}
}
