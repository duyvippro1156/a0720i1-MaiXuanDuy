package com.codegym.aopcustomermanagement.repository;


import com.codegym.aopcustomermanagement.model.Customer;
import com.codegym.aopcustomermanagement.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

}
