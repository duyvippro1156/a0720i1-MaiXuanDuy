package service.impl;

import dao.IEmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import model.Employee;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private IEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList =employeeDAO.getAllEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        try {
            this.employeeDAO.insertEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        try {
            return this.employeeDAO.getEmployee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(int id, Employee employee) {
        try {
            employeeDAO.updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try {
            this.employeeDAO.deleteEmployee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findByName(String name) {
        return this.findAll().stream().filter(Customer -> Customer.getEmployee_name().contains(name)).collect(Collectors.toList());
    }
}
