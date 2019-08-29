package com.metrocenter.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
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
	private CustomersRepository repo;

	@GetMapping
	public Iterable<Customer> getAll()
	{
		// TODO return the request
		//
		return repo.findAll();
	}

	@GetMapping("/{fname}")
	public Customer getCustomer(@PathVariable("fname") long firstName)
	{
		// TODO return the request
		return(null);
		/* return repo.findById(firstName); */
	}

	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri)
	{
		if (newCustomer.getName() == null || newCustomer.getEmail() == null)
		{
			return ResponseEntity.badRequest().build();
		}
		newCustomer = repo.save(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{fname}")
				.buildAndExpand(newCustomer.getName()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	@PutMapping("/{fname}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer, @PathVariable("fname") String firstName)
	{
		if (newCustomer.getName() == firstName || newCustomer.getName() == null || newCustomer.getName() == null)
		{
			return ResponseEntity.badRequest().build();
		}
		newCustomer = repo.save(newCustomer);
		return ResponseEntity.ok().build();
	}

//	@RequestMapping("/{fname}/{lname}")
//	public Customer getCustomer(@PathVariable("fname") String firstName,
//							@PathVariable("lname") String lastName) {
//		//TODO return the request
//		return repo.getCustomerByName(firstName);
//	}
}
