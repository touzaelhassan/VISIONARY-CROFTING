package com.application.controllers.web;

import com.application.entities.Customer;
import com.application.services.classes.CustomerServiceClass;
import com.application.services.interfaces.CustomerServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerServiceInterface customerServiceBean;

    public CustomerController(CustomerServiceInterface customerServiceBean) { this.customerServiceBean = customerServiceBean; }

    @GetMapping("")
    public List<Customer> getCustomers(){ return customerServiceBean.getCustomers(); }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId){ return customerServiceBean.getCustomerById(customerId); }

    @PostMapping("/create")
    public Customer addCustomer(@RequestBody Customer customer){ return customerServiceBean.addCustomer(customer); }

}
