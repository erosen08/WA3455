package com.customersauthapi.authentication;

import org.springframework.web.client.RestTemplate;

import com.customersauthapi.domain.Customer;

public class Authenticator {
	
	static String customersAPI="http://localhost:8080/api/customers";
	
	public static boolean checkPassword(String username, String password) {
		RestTemplate template = new RestTemplate();
		Customer[] customers = template.getForObject(customersAPI, Customer[].class);
		
		for(Customer customer : customers) {
			if(customer.name == username && customer.password == password) {
				return true;
			}
		}
		
		return false;
		
		
	}
}
