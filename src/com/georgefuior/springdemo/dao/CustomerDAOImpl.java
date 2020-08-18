package com.georgefuior.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.georgefuior.springdemo.entity.Customer;

@Repository  //need Spring be able component scann and also handle acception translation
public class CustomerDAOImpl implements CustomerDAO {
	
	
	
	@Autowired //need to inject the Hibernate sessionFactory to communicate with DB
	private SessionFactory sessionFactory;

	
	@Override
	@Transactional // for Open and close Transactions automatically
	public List<Customer> getCustomers() {
		
		//get the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
		
		//execute query and get result list
		
		List<Customer> customers = theQuery.getResultList();
		
		//return the result list
		return customers;
	}

}
