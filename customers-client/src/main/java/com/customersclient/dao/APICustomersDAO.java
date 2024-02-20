package com.customersclient.dao;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.customersclient.domain.Customer;

@Repository
public class APICustomersDAO implements CustomersDAO {
	
	String customersAPI="http://localhost:8080/api/customers";

	@Override
	public Collection<Customer> getAllCustomers() {
		RestTemplate template = new RestTemplate();
		Customer[] customers = template.getForObject(customersAPI, Customer[].class);
		return Arrays.asList(customers);
	}
}
