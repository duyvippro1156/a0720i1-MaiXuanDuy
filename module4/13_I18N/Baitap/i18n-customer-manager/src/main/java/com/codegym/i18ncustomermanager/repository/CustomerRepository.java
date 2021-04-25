package com.codegym.i18ncustomermanager.repository;


import com.codegym.i18ncustomermanager.model.Customer;
import com.codegym.i18ncustomermanager.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

}
