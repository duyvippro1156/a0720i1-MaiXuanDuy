package com.codegym.casestudy.sevices.employee.impl;

import com.codegym.casestudy.models.employee.Position;
import com.codegym.casestudy.repositories.employee.PositionRepository;
import com.codegym.casestudy.sevices.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(int id) {
        return positionRepository.findById(id).orElse(null);
    }
}