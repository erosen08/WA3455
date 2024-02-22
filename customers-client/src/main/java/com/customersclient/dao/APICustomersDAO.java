package com.customersclient.dao;


import java.util.Arrays;
import java.util.Collection;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
		HttpHeaders headers = new HttpHeaders();
		
		//set headers to jwt
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		Customer[] customers = template.postForObject(customersAPI, entity, Customer[].class);
		return Arrays.asList(customers);
	}
	
	
	@Override
	public void addCustomer(Customer newCustomer) {
		RestTemplate template = new RestTemplate();
		template.postForObject(customersAPI, newCustomer, Customer.class);
	}

}
