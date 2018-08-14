package com.demo.backenddemo.Impl;

import java.util.List;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.backenddemo.Model.Customer;
import com.demo.backenddemo.Dao.CustomerDao;



@Repository
public class CustomerImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;	
	
	public boolean add(Customer entity) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
		return false;
	}
	
	public int save(Customer entity) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
		return 0;
	}
	
	public void delete(int id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(getById(id));
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(Customer entity) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();	
	}
	 
	public Customer findByEmail(String email, String password) {
		Session session=sessionFactory.openSession();
		String hql = "FROM Customer u WHERE u.email = '" + email +"'AND u.password ='" + password + "'" ;
		Query query = session.createQuery(hql);
		List results=null;
		results = query.list();
	/*	List results = query.list();*/
		if(results.size()>0)
			return (Customer) results.get(0);
		
		else
			return null;	
	}
	
	public boolean validate(String email, String password) {
		Session session=sessionFactory.openSession();
		String hql = "FROM Customer u WHERE u.email = '" + email +"' AND u.password ='" + password + "'" ;
		Query query = session.createQuery(hql);
		List results = query.list();
		if(results!=null)
			return true;
		else
			return false;				
	}

	public Set<Customer> findAll() {

		return null;
	}
	public List<Customer> getAllCustomer() {
		Session session = sessionFactory.openSession();  
		session.beginTransaction();  
		List<Customer> customerList = session.createCriteria(Customer.class)  
		    .list();  
		  session.getTransaction().commit();  
		  session.close();  
		  return customerList;  
/*		String hql = "from Customer";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Customer> customerList = query.getResultList();
		return customerList;*/
	}
public Customer getById(int id) {
		System.out.println("Starting of the getById method in DaoImpl");
		Session session = sessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
		  }	

}
