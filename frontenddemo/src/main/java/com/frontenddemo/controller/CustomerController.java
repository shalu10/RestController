package com.frontenddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.backenddemo.Model.Customer;
import com.demo.backenddemo.service.UserService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private UserService userService;
	private Customer customer;
	
	
	@PostMapping("/add")
	public ResponseEntity<Customer> add(@RequestBody Customer customer) {
	 HttpHeaders headers = new HttpHeaders();
	 if (customer == null) {
	  return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
	 }
	userService.add(customer);
	 headers.add("Employee Created  - ", String.valueOf(customer.getId()));
	 return new ResponseEntity<Customer>(customer, headers, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/list")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> customers = userService.getAllCustomer();
		if (customers == null) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getUser(@PathVariable("id") int id) {
		customer = userService.getById(id);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> update( @RequestBody Customer customer) {
	    userService.update(customer);
	    return ResponseEntity.ok().body("Customer has been updated successfully.");
	}




	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		try {
	   userService.delete(id);
	   return ResponseEntity.ok().body("customer has been deleted successfully.");
	}catch(Exception e){
	return ResponseEntity.ok().body("Please Insert Customer In This Id");
	}
	}

}
