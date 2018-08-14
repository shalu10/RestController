package com.demo.backenddemo.service;

import java.util.List;

import com.demo.backenddemo.Model.Customer;



public interface UserService {
	List<Customer> getAllCustomer();
  	Customer getById(int id);
  	public boolean add(Customer customer);
  	public int save(Customer customer); 
  	public void update(Customer customer);
  	public void delete(int id);

}
