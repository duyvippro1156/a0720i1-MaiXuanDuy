package com.codegym.aopcustomermanagement.service.impl;

import com.codegym.aopcustomermanagement.model.Customer;
import com.codegym.aopcustomermanagement.model.Province;
import com.codegym.aopcustomermanagement.repository.CustomerRepository;
import com.codegym.aopcustomermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() throws Exception {
        if (true) throw new Exception("a dummy exception");
        return customerRepository.findAll();
    }


    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
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
