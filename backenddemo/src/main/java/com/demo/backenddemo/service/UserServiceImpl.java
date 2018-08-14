package com.demo.backenddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.backenddemo.Dao.CustomerDao;
import com.demo.backenddemo.Model.Customer;



@Service
public class UserServiceImpl implements UserService {
@Autowired
private CustomerDao customerDao;

@Override
public List<Customer> getAllCustomer() {
	return customerDao.getAllCustomer();
	
}

@Override
public Customer getById(int id) {
	  return customerDao.getById(id); 
}

@Override
public boolean add(Customer customer) {
	return customerDao.add(customer);
}

@Override
public int save(Customer customer) {
	return customerDao.save(customer);
}

@Override
public void update(Customer customer) {
	customerDao.update(customer);
	
}

@Override
public void delete(int id) {
	customerDao.delete(id);
	
}

}
