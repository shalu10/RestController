package com.demo.backenddemo.Dao;

import java.util.List;


import java.util.Set;
import com.demo.backenddemo.Model.Customer;


public interface CustomerDao {
	public boolean add(Customer entity);
	public int save(Customer entity);
	public void delete(int id);
	public void update(Customer entity);
	public Customer getById(int id);
	public Customer findByEmail(String email,String password);
	public boolean validate(String email,String password);
	public Set<Customer> findAll();
	public List<Customer> getAllCustomer();
}
