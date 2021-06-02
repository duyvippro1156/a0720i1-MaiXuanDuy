package com.codegym.casestudy.sevices.employee.impl;

import com.codegym.casestudy.models.employee.Education;
import com.codegym.casestudy.repositories.employee.EducationRepository;
import com.codegym.casestudy.sevices.employee.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EducationRepository educationRepository;

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Education findById(int id) {
        return educationRepository.findById(id).orElse(null);
    }
}
