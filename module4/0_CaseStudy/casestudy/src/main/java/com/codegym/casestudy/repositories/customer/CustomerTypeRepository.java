package com.codegym.casestudy.repositories.customer;

import com.codegym.casestudy.models.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
