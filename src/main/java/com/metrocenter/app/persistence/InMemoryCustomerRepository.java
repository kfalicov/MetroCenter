package com.metrocenter.app.persistence;

import java.util.ArrayList;

import com.metrocenter.app.controllers.Customer;

public class InMemoryCustomerRepository {
	private ArrayList<Customer> customers;
	
	public ArrayList<Customer> getAll(){
		return customers;
	}
	public Customer getCustomerByName(String name) {
		for (Customer customer : customers) {
	        if (customer.getName().equals(name)) {
	            return customer;
	        }
	    }
	    return null; 
	}
}
