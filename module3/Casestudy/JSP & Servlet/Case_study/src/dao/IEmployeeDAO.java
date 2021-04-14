package dao;

import model.Employee;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDAO {
    public void insertEmployee(Employee employee) throws SQLException;

    public Employee getEmployee(int id) throws SQLException;

    public List<Employee> getAllEmployee() throws SQLException;

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;
}
