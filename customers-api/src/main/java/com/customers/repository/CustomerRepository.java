package com.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customers.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
