package com.codegym.casestudy.sevices.employee.impl;

import com.codegym.casestudy.models.employee.Division;
import com.codegym.casestudy.repositories.employee.DivisionRepository;
import com.codegym.casestudy.sevices.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findById(int id) {
        return divisionRepository.findById(id).orElse(null);
    }
}
