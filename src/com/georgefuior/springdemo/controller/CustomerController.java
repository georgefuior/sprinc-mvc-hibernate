package com.georgefuior.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.georgefuior.springdemo.dao.CustomerDAO;
import com.georgefuior.springdemo.entity.Customer;

@Controller 
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the DAO into this controller
	
	@Autowired //SPRING WILL SCANN FOR COMPONENTS THAT IMPLEMENTS CustomerDAO interface
	private CustomerDAO customerDAO;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get customers from DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//add the customer to the spring MVC model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customer";
	}

}
