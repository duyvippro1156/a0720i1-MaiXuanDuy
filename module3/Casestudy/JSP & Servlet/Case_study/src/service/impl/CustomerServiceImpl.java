package service.impl;

import dao.ICustomerDAO;
import dao.impl.CustomerDAOImpl;
import model.Customer;
import service.CustomerService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CustomerServiceImpl implements CustomerService {

    private ICustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = customerDAO.getAllCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerList;
    }

    @Override
    public void save(Customer customer) {
        try {
            customerDAO.insertCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        try {
            return customerDAO.getCustomer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        try {
            customerDAO.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try {
            customerDAO.deleteCustomer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findByName(String name) {
        return this.findAll().stream().filter(Customer -> Customer.getCus_name().contains(name)).collect(Collectors.toList());
    }
}
