package com.autentication.provider.controller;

import com.autentication.provider.entiry.Customer;
import com.autentication.provider.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public Customer createCustomer(@RequestBody Customer customer) throws ExecutionException, InterruptedException {
        return customerService.createCustomer(customer);
    }

    @GetMapping()
    public List<Customer> getCustomer() throws ExecutionException, InterruptedException {
        return customerService.getCustomer();
    }
}