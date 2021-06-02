package com.codegym.casestudy.sevices.service;

import com.codegym.casestudy.models.services.RentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentTypeService {
    List<RentType> findAll();
}
