package com.application.services.interfaces;

import com.application.entities.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    Customer addCustomer(Customer customer);
    Customer getCustomerById(Integer customerId);
    List<Customer> getCustomers();

}
