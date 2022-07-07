package com.customerManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customerManagement.entity.Customer;
import com.customerManagement.service.CustomerService;
import com.customerManagement.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String list_Customers(Model theModel) {

		System.out.println("request recieved");
		// get Books from db
		List<Customer> theCustomers = customerService.showAll();

		// add to the spring model
		theModel.addAttribute("Customer", theCustomers);

		return "customer-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("Customer", theCustomer);

		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model theModel) {

		// get the Book from the service
		Customer theCustomer = customerService.findById(id);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);

		// send over to our form
		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String Email) {

		if (!firstName.equals("") || !lastName.equals("") || !Email.equals("")) {
			Customer customer = null;
			if (id != 0) {
				customer = customerService.findById(id);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setEmail(Email);
			} else {
				customer = new Customer(firstName, lastName, Email);
			}
			customerService.save(customer);
			return "redirect:./list";
		} else {
			return "redirect:./customer/showFormForUpdate";
		}

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {

		// delete the Book
		customerService.deleteById(id);

		// redirect to /Books/list
		return "redirect:/customer/list";

	}

}
