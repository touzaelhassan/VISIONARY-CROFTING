package com.application.controllers.web;

import com.application.entities.Customer;
import com.application.services.classes.CustomerServiceClass;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerServiceClass customerServiceClass;

    public CustomerController(CustomerServiceClass customerServiceClass) { this.customerServiceClass = customerServiceClass; }

    @GetMapping("")
    public List<Customer> getCustomers(){ return customerServiceClass.getCustomers(); }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId){ return customerServiceClass.getCustomerById(customerId); }

    @PostMapping("/create")
    public Customer addCustomer(@RequestBody Customer customer){ return customerServiceClass.addCustomer(customer); }

}
