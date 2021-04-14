package com.example.handel_exeption_customer_management.service;

import com.example.handel_exeption_customer_management.model.Customer;
import com.example.handel_exeption_customer_management.model.Province;
import com.example.handel_exeption_customer_management.service.exception.DuplicateEmailException;

public interface CustomerService {
    Iterable<Customer> findAll() throws Exception;

    Customer findById(Long id);

    Customer save(Customer customer) throws DuplicateEmailException;

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}