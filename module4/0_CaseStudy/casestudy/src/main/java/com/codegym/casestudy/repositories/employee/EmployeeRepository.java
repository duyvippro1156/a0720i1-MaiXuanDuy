package com.codegym.casestudy.repositories.employee;

import com.codegym.casestudy.models.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findEmployeesByNameContains(String name, Pageable pageable);
//    @Query("SELECT e FROM Employee e WHERE e.users.username = :username")
    Employee findAllByUsers_Username(String username);
}
