package com.application.services.classes;

import com.application.entities.Customer;
import com.application.repositories.CustomerRepository;
import com.application.services.interfaces.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceClass implements CustomerServiceInterface {

    private CustomerRepository customerRepositoryBean;

    @Autowired
    public CustomerServiceClass(CustomerRepository customerRepositoryBean) { this.customerRepositoryBean = customerRepositoryBean; }

    @Override
    public Customer addCustomer(Customer customer) { return customerRepositoryBean.save(customer); }

    @Override
    public Customer getCustomerById(Integer customerId) { return  customerRepositoryBean.findById(customerId).orElse(null); }

    @Override
    public Customer getCustomerByEmail(String email) { return customerRepositoryBean.getByEmail(email); }

    @Override
    public List<Customer> getCustomers() { return customerRepositoryBean.findAll(); }

}
