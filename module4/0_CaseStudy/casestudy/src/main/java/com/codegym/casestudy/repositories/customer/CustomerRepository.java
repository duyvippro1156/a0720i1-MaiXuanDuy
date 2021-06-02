package com.codegym.casestudy.repositories.customer;

import com.codegym.casestudy.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByIdContainsOrNameContains(String id, String name, Pageable pageable);
}
