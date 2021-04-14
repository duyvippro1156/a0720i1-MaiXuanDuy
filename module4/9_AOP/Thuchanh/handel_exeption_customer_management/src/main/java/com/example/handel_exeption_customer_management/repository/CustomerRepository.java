package com.example.handel_exeption_customer_management.repository;


import com.example.handel_exeption_customer_management.model.Customer;
import com.example.handel_exeption_customer_management.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

}
