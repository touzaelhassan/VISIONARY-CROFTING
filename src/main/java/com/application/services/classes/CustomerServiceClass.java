package com.application.services.classes;

import com.application.entities.Customer;
import com.application.repositories.CustomerRepository;
import com.application.services.interfaces.CustomerServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceClass implements CustomerServiceInterface {

    CustomerRepository customerRepository;

    public CustomerServiceClass(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    @Override
    public Customer addCustomer(Customer customer) { return customerRepository.save(customer); }

    @Override
    public Customer getCustomerById(Integer customerId) { return  customerRepository.findById(customerId).orElse(null); }

    @Override
    public List<Customer> getCustomers() { return customerRepository.findAll(); }

}
