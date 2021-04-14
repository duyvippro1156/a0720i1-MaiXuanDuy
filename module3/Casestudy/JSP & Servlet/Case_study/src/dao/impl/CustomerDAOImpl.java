package dao.impl;

import dao.ICustomerDAO;
import model.Customer;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements ICustomerDAO {
    private static final String INSERT_CUSTOMER_SQL = "Insert into customer(id, name, birthday, gender, id_card, phone_number, email, address, id_type_customer) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_CUSTOMER_BY_ID = "Select * from customer where id = ?";
    private static final String SELECT_ALL_CUSTOMER = "Select * from customer";
    private static final String DELETE_USER_BY_ID = "Delete from customer where id = ?";
    private static final String UPDATE_USER = "Update customer set name = ?, birthday = ?, gender = ?, id_card = ?, phone_number = ?, email = ?, address = ?, id_type_customer = ? where id = ?";

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);

        preparedStatement.setInt(1, customer.getCustomer_id());
        preparedStatement.setString(2, customer.getCus_name());
        preparedStatement.setString(3, customer.getCustomer_birthday());
        preparedStatement.setString(4, customer.getCustomer_gender());
        preparedStatement.setString(5, customer.getCustomer_id_card());
        preparedStatement.setString(6, customer.getCustomer_phone());
        preparedStatement.setString(7, customer.getCustomer_email());
        preparedStatement.setString(8, customer.getCustomer_address());
        preparedStatement.setInt(9, customer.getCustomer_type_id());

        preparedStatement.executeUpdate();
    }

    @Override
    public Customer getCustomer(int id) throws SQLException {
        Customer customer = null;

        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getNString("name");
            String birthday = resultSet.getString("birthday");
            String gender = resultSet.getNString("gender");
            String idCard = resultSet.getNString("id_card");
            String phoneNumber = resultSet.getNString("phone_number");
            String email = resultSet.getNString("email");
            String address = resultSet.getNString("address");
            int idTypeCustomer = resultSet.getInt("id_type_customer");

            customer = new Customer(id, idTypeCustomer, name, birthday, gender, idCard,phoneNumber, email, address);
        }


        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() throws SQLException {
        List<Customer> customerList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getNString("name");
            String birthday = resultSet.getString("birthday");
            String gender = resultSet.getNString("gender");
            String idCard = resultSet.getNString("id_card");
            String phoneNumber = resultSet.getNString("phone_number");
            String email = resultSet.getNString("email");
            String address = resultSet.getNString("address");
            int idTypeCustomer = resultSet.getInt("id_type_customer");
            customerList.add(new Customer(id, idTypeCustomer, name, birthday, gender, idCard,phoneNumber, email, address));
        }

        return customerList;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
        preparedStatement.setString(1, customer.getCus_name());
        preparedStatement.setString(2, customer.getCustomer_birthday());
        preparedStatement.setString(3, customer.getCustomer_gender());
        preparedStatement.setString(4, customer.getCustomer_id_card());
        preparedStatement.setString(5, customer.getCustomer_phone());
        preparedStatement.setString(6, customer.getCustomer_email());
        preparedStatement.setString(7, customer.getCustomer_address());
        preparedStatement.setInt(8, customer.getCustomer_type_id());
        preparedStatement.setInt(9, customer.getCustomer_id());

        return preparedStatement.executeUpdate() > 0;
    }
}
