package com.codegym.phonemanagement.service;

import com.codegym.phonemanagement.model.Smartphone;
import org.springframework.stereotype.Service;

@Service
public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone phone);
    Smartphone remove(Integer id);
}
