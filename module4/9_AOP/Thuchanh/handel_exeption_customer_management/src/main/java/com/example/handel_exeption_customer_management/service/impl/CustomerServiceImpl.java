package com.example.handel_exeption_customer_management.service.impl;

import com.example.handel_exeption_customer_management.model.Customer;
import com.example.handel_exeption_customer_management.model.Province;
import com.example.handel_exeption_customer_management.repository.CustomerRepository;
import com.example.handel_exeption_customer_management.service.CustomerService;
import com.example.handel_exeption_customer_management.service.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public Customer save(Customer customer) throws DuplicateEmailException {
        try {
            return customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
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
