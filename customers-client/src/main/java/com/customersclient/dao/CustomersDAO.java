package com.customersclient.dao;

import java.util.Collection;

import com.customersclient.domain.Customer;

public interface CustomersDAO {
	public Collection<Customer> getAllCustomers();
	//public void addCustomer(Customer customer);
	//public void updateCustomer(Customer customer);
	//public void deleteCustomer(Customer customer);
}
