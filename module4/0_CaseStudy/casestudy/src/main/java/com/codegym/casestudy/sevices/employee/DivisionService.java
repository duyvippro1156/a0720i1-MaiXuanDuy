package com.codegym.casestudy.sevices.employee;

import com.codegym.casestudy.models.employee.Division;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DivisionService {
    List<Division> findAll();

    Division findById(int id);
}
