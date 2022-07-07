package com.customerManagement.service;

import java.util.List;

import com.customerManagement.entity.Customer;

public interface CustomerService {

	public List<Customer> showAll();

	public Customer findById(int id);

	public void save(Customer customer);

	public void deleteById(int id);
}
