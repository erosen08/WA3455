package com.customers.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Customer> findById(long id) {
		return repo.findById(id);
	}

	public Customer saveCustomer(Customer newCustomer) {
		return repo.save(newCustomer);
	}
	
	public void deleteCustomer(Customer customer) {
		repo.delete(customer);
	}

	public Optional<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}
}
