package service;

import model.Motel;

import java.sql.SQLException;
import java.util.List;

public interface IMotelService {
    void saveMotel(Motel motel) throws SQLException;

    Motel getMotelById(int id) throws SQLException;

    List<Motel> getAllMotel() throws SQLException;

    boolean deleteMotel(int id) throws SQLException;

    boolean updateMotel(int id, Motel motel) throws SQLException;

    List<Motel> findByNameCustomer(String name) throws SQLException;

    List<Motel> findByPhone(String phone) throws SQLException;




}
