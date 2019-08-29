package com.metrocenter.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.metrocenter.domain.Customer;
import com.metrocenter.repository.CustomersRepository;

@RestController
@RequestMapping("/customers")
public class CustomerAPI
{

	@Autowired
	CustomersRepository repo;

	@GetMapping
	public Iterable<Customer> getAll()
	{
		// TODO return the request
		//
		return repo.findAll();
	}

	@GetMapping("/{fname}")

	public Customer getCustomerByName(@PathVariable("fname") String firstName)
	{
		// TODO return the request
		return repo.findByName(firstName);

	}

//	@GetMapping("/{id}")
//	public Customer getCustomerById(@PathVariable("id") long id)
//	{
//		// TODO return the request
//		return repo.findOne(id);
//	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri)
	{
		if (newCustomer.getId()!=0 || newCustomer.getName() == null || newCustomer.getEmail() == null)
		{
			return ResponseEntity.badRequest().build();
		}
		newCustomer = repo.save(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomer.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	@PutMapping("/{fname}")

	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer, @PathVariable("fname") String fName)

	{
		Customer c = repo.findByName(fName);
		if (newCustomer.getName() == null || c  == null)
		{
			c = repo.save(newCustomer);
		}else {
			c.setName(newCustomer.getName());
				c = repo.save(c);
		}
		return ResponseEntity.ok().build();
	}
	
	 @DeleteMapping("/{fname}")
	  public ResponseEntity<?> deleteCustomer(@PathVariable ("fname")String fName) {
		
			Customer C = repo.findByName(fName);
		           repo.deleteById(C.getId());
			return ResponseEntity.ok().build();
	       
	    }
//	@RequestMapping("/{fname}/{lname}")
//	public Customer getCustomer(@PathVariable("fname") String firstName,
//							@PathVariable("lname") String lastName) {
//		//TODO return the request
//		return repo.getCustomerByName(firstName);
//	}
}
