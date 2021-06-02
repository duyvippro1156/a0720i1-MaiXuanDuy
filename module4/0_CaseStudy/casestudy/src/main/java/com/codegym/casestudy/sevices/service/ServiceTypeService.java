package com.codegym.casestudy.sevices.service;

import com.codegym.casestudy.models.services.ServiceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceTypeService {
    List<ServiceType> findAll();
    ServiceType findById(int id);
}
