package com.customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customers.domain.Customer;
import com.customers.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired CustomerRepository repo;
	
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

}
