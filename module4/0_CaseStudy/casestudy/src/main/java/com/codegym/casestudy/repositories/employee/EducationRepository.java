package com.codegym.casestudy.repositories.employee;

import com.codegym.casestudy.models.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
}
