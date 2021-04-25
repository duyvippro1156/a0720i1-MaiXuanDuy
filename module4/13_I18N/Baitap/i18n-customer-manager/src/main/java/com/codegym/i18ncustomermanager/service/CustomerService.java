package com.codegym.i18ncustomermanager.service;

import com.codegym.i18ncustomermanager.model.Customer;
import com.codegym.i18ncustomermanager.model.Province;

public interface CustomerService {
    Iterable<Customer> findAll() throws Exception;

    Customer findById(Long id);

    Customer save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}