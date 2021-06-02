package com.codegym.casestudy.sevices.customer;

import com.codegym.casestudy.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    List<Customer> findAll();
    Customer findById(String id);
    Customer save(Customer customer);
    void delete(String id);
    Page<Customer> findAllByIdOrName(String search, Pageable pageable);
    boolean existById(String id);
}
