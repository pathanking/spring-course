package com.myorg.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myorg.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}