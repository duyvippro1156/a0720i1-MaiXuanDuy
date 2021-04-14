package dao;

import model.Payment;

import java.sql.SQLException;

public interface IPaymentDAO {
    Payment getPaymentById(int id) throws SQLException;
}
