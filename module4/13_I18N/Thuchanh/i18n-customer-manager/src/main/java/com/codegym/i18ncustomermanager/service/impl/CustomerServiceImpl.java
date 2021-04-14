package com.codegym.i18ncustomermanager.service.impl;

import com.codegym.i18ncustomermanager.model.Customer;
import com.codegym.i18ncustomermanager.model.Province;
import com.codegym.i18ncustomermanager.repository.*;
import com.codegym.i18ncustomermanager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }


    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
            return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }
}
