package com.customersclient.dao;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.customersclient.domain.Customer;

@Repository
public class APICustomersDAO implements CustomersDAO {
	
	String customersAPI="http://localhost:8080/api/customers";
	//String authAPI=""

	@Override
	//provide header http request headers
	public Collection<Customer> getAllCustomers() {
		RestTemplate template = new RestTemplate();
		Customer[] customers = template.getForObject(customersAPI, Customer[].class);
		return Arrays.asList(customers);
	}
	
	//login call authentication service
	//auth talks to customer api and gets response from there
	//auth service sends back bearer to client
	//client then calls customer api with bearer/header
	
//	@Override
//	public void addCustomer(Customer newCustomer) {
//		RestTemplate template = new RestTemplate();
//		template.postForObject(customersAPI, newCustomer, Customer.class);
//	}
}
