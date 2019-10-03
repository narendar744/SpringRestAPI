package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService service;
@GetMapping("/customers")
public List<Customer> getCustomers() {
	return service.getCustomers();
	
}
@GetMapping("/customers/{customerId}")
public Customer getCustomers(@PathVariable("customerId") int customerId) {
	
	Customer theCustomer = service.getCustomer(customerId);
	
	if(theCustomer==null) {
		throw new CustomerNotFoundException("customer not found with id of  "+ customerId);
	}	
	return theCustomer;
	
}
@PostMapping("/customers")
public Customer  addCustomer(@RequestBody Customer customer) {
	customer.setId(0);
	service.saveCustomer(customer);
	return customer;
}
@PutMapping("/customers")
public Customer updatecustomer(@RequestBody Customer customer)
{
	if(customer.getId() == 0){
        throw new CustomerNotFoundException("customer not found pease provide correct details..");
    }
    service.saveCustomer(customer);
    return customer;
}

@DeleteMapping("/customers/{customerId}")
public String deleteCustomer(@PathVariable("customerId") int customerId) {
	Customer customer=service.getCustomer(customerId);
	if(customer==null) {
		throw new CustomerNotFoundException("customer not found with id " +customerId);
	}
	service.deleteCustomer(customerId);
	return "customer deleteted with id of "+customerId;
	
}


}
