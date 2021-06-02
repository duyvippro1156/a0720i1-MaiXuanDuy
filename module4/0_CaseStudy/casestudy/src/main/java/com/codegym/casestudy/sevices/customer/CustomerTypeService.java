package com.codegym.casestudy.sevices.customer;

import com.codegym.casestudy.models.customer.CustomerType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerTypeService {
    List<CustomerType> findAll();
}
