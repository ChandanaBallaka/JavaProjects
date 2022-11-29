package com.japa.testing.oneToOne_JPA.controller;


import com.japa.testing.oneToOne_JPA.entity.Customer;
import com.japa.testing.oneToOne_JPA.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }

    @GetMapping("/findCustomer")
    public List<Customer> getcustomer(){
        return customerRepository.findAll();
    }

    @DeleteMapping("/deletecustomer/{id}")
    public  String deleteCustomer(@PathVariable int id){
        customerRepository.deleteById(id);
        return "Removed";
    }

    @PutMapping("/updatecustomer")
    public Customer updatecustomer(@RequestBody Customer customer)
    {
        Customer existing = customerRepository.findById(customer.getCustId()).orElse(null);
        existing.setCustName(customer.getCustName());
        existing.setLocation(customer.getLocation());
        return customerRepository.save(existing);
    }

}
