package com.customersclient.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.customersclient.dao.CustomersDAO;
import com.customersclient.domain.Customer;

@Controller
public class CustomersController {
	
	@Autowired
	private CustomersDAO customersDAO;
	
	@GetMapping("/index.html")
	public String getIndex() {
		return "/index";
	}
	
	@GetMapping("/")
	public String getRoot() {
		return "redirect:/index.html";
	}
	
	@RequestMapping("/browseCustomers")
	public ModelAndView browseCustomers() {
		Collection<Customer> list = customersDAO.getAllCustomers();
		return new ModelAndView("browseCustomers", "customers", list);
	}

}
