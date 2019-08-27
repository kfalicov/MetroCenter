package com.metrocenter.app.persistence;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.metrocenter.app.controllers.Customer;

@Component
public class InMemoryCustomerRepository {
	
	private ArrayList<Customer> customers;
	
	public InMemoryCustomerRepository() {
		Customer c1 = new Customer("Jeff", "jeff1@jeff.com", "password");
		Customer c2 = new Customer("Jefff", "jeff2@jeff.com", "password");
		Customer c3 = new Customer("Jeffff", "jeff3@jeff.com", "password");
		Customer c4 = new Customer("Jefffff", "jeff4@jeff.com", "password");
		Customer c5 = new Customer("Jeffffff", "jeff5@jeff.com", "password");
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
	}
	
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
