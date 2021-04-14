package com.example.handel_exeption_customer_management.service;

import com.example.handel_exeption_customer_management.model.Province;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
