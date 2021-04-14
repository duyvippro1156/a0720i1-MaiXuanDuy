package com.codegym.aopcustomermanagement.service;

import com.codegym.aopcustomermanagement.model.Customer;
import com.codegym.aopcustomermanagement.model.Province;

import java.util.List;

public interface CustomerService {
    Iterable<Customer> findAll() throws Exception;

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}