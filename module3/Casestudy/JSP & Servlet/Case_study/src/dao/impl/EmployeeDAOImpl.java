package dao.impl;

import dao.IEmployeeDAO;
import model.Employee;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements IEmployeeDAO {
    public static Connection connection = DBConnection.getConnection();
    public static final String INSERT_EMPLOYEE = "insert into employee(id, name, birthday, employee_id_card, phone_number, email, address, salary, id_level_employee, id_position_employee, id_department_employee) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_EMPLOYEE_BY_ID = "select * from employee where id = ?";
    public static final String GET_ALL_EMPLOYEE = "select * from employee";
    public static final String DELETE_EMPLOYEE = "delete from employee where id = ?";
    public static final String UPDATE_EMPLOYEE = "update employee set name = ?, birthday = ?, employee_id_card = ?, phone_number = ?, email = ?, address = ?, salary = ?, id_level_employee = ?, id_position_employee = ?, id_department_employee = ? where id = ?";
    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
        preparedStatement.setInt(1, employee.getEmployee_id());
        preparedStatement.setString(2, employee.getEmployee_name());
        preparedStatement.setString(3, employee.getEmployee_birthday());
        preparedStatement.setString(4, employee.getEmployee_id_card());
        preparedStatement.setString(5, employee.getEmployee_phone());
        preparedStatement.setString(6, employee.getEmployee_email());
        preparedStatement.setString(7, employee.getEmployee_address());
        preparedStatement.setString(8, employee.getEmployee_salary());
        preparedStatement.setInt(9, employee.getEducation_degree_id());
        preparedStatement.setInt(10, employee.getPosition_id());
        preparedStatement.setInt(11, employee.getDivision_id());
        preparedStatement.executeUpdate();
    }

    @Override
    public Employee getEmployee(int id) throws SQLException {
        Employee employee = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String birthday = resultSet.getString("birthday");
            String id_card = resultSet.getString("employee_id_card");
            String phone_number = resultSet.getString("phone_number");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String salary = resultSet.getString("salary");
            int id_level_employee = resultSet.getInt("id_level_employee");
            int id_position_employee = resultSet.getInt("id_position_employee");
            int id_department_employee = resultSet.getInt("id_department_employee");
            employee = new Employee(id,name,birthday,id_card,salary,phone_number,email,address,id_position_employee,id_level_employee, id_department_employee);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EMPLOYEE);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String birthday = resultSet.getString("birthday");
            String id_card = resultSet.getString("employee_id_card");
            String phone_number = resultSet.getString("phone_number");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String salary = resultSet.getString("salary");
            int id_level_employee = resultSet.getInt("id_level_employee");
            int id_position_employee = resultSet.getInt("id_position_employee");
            int id_department_employee = resultSet.getInt("id_department_employee");
            employeeList.add( new Employee(id,name,birthday,id_card,salary,phone_number,email,address,id_position_employee,id_level_employee, id_department_employee));
        }
        return employeeList;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
        preparedStatement.setString(1, employee.getEmployee_name());
        preparedStatement.setString(2, employee.getEmployee_birthday());
        preparedStatement.setString(3, employee.getEmployee_id_card());
        preparedStatement.setString(4, employee.getEmployee_phone());
        preparedStatement.setString(5, employee.getEmployee_email());
        preparedStatement.setString(6, employee.getEmployee_address());
        preparedStatement.setString(7, employee.getEmployee_salary());
        preparedStatement.setInt(8, employee.getEducation_degree_id());
        preparedStatement.setInt(9, employee.getPosition_id());
        preparedStatement.setInt(10, employee.getDivision_id());
        preparedStatement.setInt(11,employee.getEmployee_id());
        return preparedStatement.executeUpdate() > 0;
    }
}
