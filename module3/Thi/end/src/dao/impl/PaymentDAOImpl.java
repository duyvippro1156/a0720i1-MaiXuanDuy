package dao.impl;

import dao.IPaymentDAO;
import model.Payment;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAOImpl implements IPaymentDAO {
    public static Connection connection = DBConnection.getConnection();
    public static final String GET_PAYMENT_BY_ID = "select name_payment from payment where id = ?";

    @Override
    public Payment getPaymentById(int id) throws SQLException {
        Payment payment = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_PAYMENT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name_payment = resultSet.getNString("name_payment");
            payment = new Payment(id, name_payment);
        }
        return payment;
    }
}
