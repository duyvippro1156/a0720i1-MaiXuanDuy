package dao;

import model.Motel;

import java.sql.SQLException;
import java.util.List;

public interface IMotelDAO {
    void saveMotel(Motel motel) throws SQLException;

    Motel getMotelById(int id) throws SQLException;

    List<Motel> getAllMotel() throws SQLException;

    boolean deleteMotel(int id) throws SQLException;

    boolean updateMotel(Motel patient) throws SQLException;

}
