package dao.impl;

import dao.IMotelDAO;
import model.Motel;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotelDAOImpl implements IMotelDAO {
    public static Connection connection = DBConnection.getConnection();
    public static final String INSERT_MOTEL = "insert into motel(name_customer, phone_number, date_begin, id_payments, note) value(?, ?, ?, ?, ?)";
    public static final String GET_MOTEL_BY_ID = "select * from motel where id = ?";
    public static final String GET_ALL_MOTEL = "select * from motel";
    public static final String DELETE_MOTEL = "delete from motel where id = ?";
    public static final String UPDATE_MOTEL = "update motel set name_customer = ?, phone_number = ?, date_begin = ?, id_payments = ?, note = ? where id = ?";

    @Override
    public void saveMotel(Motel motel) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOTEL);
        preparedStatement.setString(1, motel.getName_customer());
        preparedStatement.setString(2, motel.getPhone_number());
        preparedStatement.setString(3, motel.getDate_begin());
        preparedStatement.setInt(4, motel.getPayment());
        preparedStatement.setString(5, motel.getNote());
        preparedStatement.executeUpdate();
    }

    @Override
    public Motel getMotelById(int id) throws SQLException {
        Motel motel = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_MOTEL_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name_customer = resultSet.getNString("name_customer");
            String phone_number = resultSet.getString("phone_number");
            String date_begin = resultSet.getString("date_begin");
            int id_payment = resultSet.getInt("id_payment");
            String note = resultSet.getString("note");
            motel = new Motel(id, name_customer, phone_number, date_begin, id_payment, note);
        }
        return motel;
    }

    @Override
    public List<Motel> getAllMotel() throws SQLException {
        List<Motel> motels = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_MOTEL);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name_customer = resultSet.getNString("name_customer");
            String phone_number = resultSet.getString("phone_number");
            String date_begin = resultSet.getString("date_begin");
            int id_payment = resultSet.getInt("id_payments");
            String note = resultSet.getString("note");
            motels.add(new Motel(id, name_customer, phone_number, date_begin, id_payment, note));
        }
        return motels;
    }

    @Override
    public boolean deleteMotel(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MOTEL);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateMotel(Motel motel) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOTEL);
        preparedStatement.setString(1, motel.getName_customer());
        preparedStatement.setString(2, motel.getPhone_number());
        preparedStatement.setString(3, motel.getDate_begin());
        preparedStatement.setInt(4, motel.getPayment());
        preparedStatement.setString(5, motel.getNote());
        preparedStatement.setInt(6, motel.getId());
        return preparedStatement.executeUpdate() > 0;
    }
}
