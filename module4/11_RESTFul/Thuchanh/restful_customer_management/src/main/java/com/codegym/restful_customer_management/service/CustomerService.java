package com.codegym.restful_customer_management.service;

import com.codegym.restful_customer_management.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
