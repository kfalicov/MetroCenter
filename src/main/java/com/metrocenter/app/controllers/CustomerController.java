package com.metrocenter.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrocenter.app.persistence.InMemoryCustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private InMemoryCustomerRepository repo;
	
	public ArrayList<Customer> getAllCustomers() {
		//TODO return the request
		//
		return repo.getAll();
	}
	@RequestMapping("/{fname}")
	public Customer getCustomer(@PathVariable("fname") String firstName) {
		//TODO return the request
		return repo.getCustomerByName(firstName);
	}
	
	@RequestMapping("/{fname}/{lname}")
	public Customer getCustomer(@PathVariable("fname") String firstName,
							@PathVariable("lname") String lastName) {
		//TODO return the request
		return repo.getCustomerByName(firstName);
	}
}
