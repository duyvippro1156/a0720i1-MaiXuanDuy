package com.codegym.casestudy.repositories.employee;

import com.codegym.casestudy.models.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
