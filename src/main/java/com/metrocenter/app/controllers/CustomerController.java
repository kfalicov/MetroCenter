package com.metrocenter.app.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	public String getAllCustomers() {
		//TODO return the request
		//
		return null;
	}
	@RequestMapping("/{fname}")
	public String getCustomer(@PathVariable("fname") String firstName) {
		//TODO return the request
		return null;
	}
	
	@RequestMapping("/{fname}/{lname}")
	public String getCustomer(@PathVariable("fname") String firstName,
							@PathVariable("lname") String lastName) {
		//TODO return the request
		return null;
	}
}
