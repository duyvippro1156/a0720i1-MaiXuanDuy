package com.codegym.casestudy.sevices.employee.impl;

import com.codegym.casestudy.models.employee.Employee;
import com.codegym.casestudy.repositories.employee.EmployeeRepository;
import com.codegym.casestudy.sevices.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByUsername(String username) {
        return employeeRepository.findAllByUsers_Username(username);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
//    public void delete(int id) throws SQLIntegrityConstraintViolationException {
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findByName(String search, Pageable pageable) {
        return employeeRepository.findEmployeesByNameContains(search, pageable);
    }
}
