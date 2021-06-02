package com.codegym.casestudy.sevices.employee;

import com.codegym.casestudy.models.employee.Education;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationService {
    List<Education> findAll();
    Education findById(int id);
}
