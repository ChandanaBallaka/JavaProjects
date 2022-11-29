package com.japa.robosoft.oneToMany_JPA.controller;


import com.japa.robosoft.oneToMany_JPA.dto.OrderRequest;
import com.japa.robosoft.oneToMany_JPA.dto.OrderResponse;
import com.japa.robosoft.oneToMany_JPA.entity.Customer;
import com.japa.robosoft.oneToMany_JPA.repository.CustomerRepository;
import com.japa.robosoft.oneToMany_JPA.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }

}
