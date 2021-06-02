package com.codegym.casestudy.repositories.employee;

import com.codegym.casestudy.models.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {
}
