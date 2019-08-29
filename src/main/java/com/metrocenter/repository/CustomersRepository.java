package com.metrocenter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.metrocenter.domain.Customer;

@Component
public interface CustomersRepository extends CrudRepository<Customer, Long>
{

//	private ArrayList<Customer> customers;
//
//	public CustomersRepository()
//	{
//		Customer c1 = new Customer("Jeff", "jeff1@jeff.com", "password");
//		Customer c2 = new Customer("Jefff", "jeff2@jeff.com", "password");
//		Customer c3 = new Customer("Jeffff", "jeff3@jeff.com", "password");
//		Customer c4 = new Customer("Jefffff", "jeff4@jeff.com", "password");
//		Customer c5 = new Customer("Jeffffff", "jeff5@jeff.com", "password");
//		customers = new ArrayList<Customer>();
//		customers.add(c1);
//		customers.add(c2);
//		customers.add(c3);
//		customers.add(c4);
//		customers.add(c5);
//	}
//
//	public ArrayList<Customer> getAll()
//	{
//		return customers;
//	}
//
//	public Customer getCustomerByName(String name)
//	{
//		for (Customer customer : customers)
//		{
//			if (customer.getName().equalsIgnoreCase(name))
//			{
//				return customer;
//			}
//		}
//		return null;
//	}
//
//	public Customer save(Customer customer)
//	{
//		Customer existing = getCustomerByName(customer.getName());
//		if(existing != null) {
//			//if the customer is in the list, modify their values to reflect the new customer object
//			existing.setEmail(customer.getEmail());
//			return existing;
//		}else {
//			customers.add(customer);
//			return customer;
//		}
//	}
}
