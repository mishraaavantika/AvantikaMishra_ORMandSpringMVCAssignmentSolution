package com.customerManagement.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customerManagement.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory factory;
	private Session session;

	@Autowired // automatically inject the SessionFactory dependency
	public CustomerServiceImpl(SessionFactory factory) {
		this.factory = factory;
		setSession();
	}

	private void setSession() {
		try {
			session = factory.getCurrentSession();
		} catch (Exception ex) {
			session = factory.openSession();
		}
	}

	@Override
	public List<Customer> showAll() {
		session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").getResultList();
		session.getTransaction().commit();
		return customers;
	}

	@Override
	public Customer findById(int id) {
		session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public void save(Customer student) {
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}

	@Override
	public void deleteById(int id) {
		session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		session.getTransaction().commit();
	}
}
