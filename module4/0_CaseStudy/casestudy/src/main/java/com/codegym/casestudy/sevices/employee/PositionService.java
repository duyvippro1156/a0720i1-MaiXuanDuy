package com.codegym.casestudy.sevices.employee;

import com.codegym.casestudy.models.employee.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PositionService {
    List<Position> findAll();

    Position findById(int id);
}
