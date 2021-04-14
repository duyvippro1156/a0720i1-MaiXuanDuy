package service.Impl;

import dao.IMotelDAO;
import dao.impl.MotelDAOImpl;
import model.Motel;
import service.IMotelService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class MotelServiceImpl implements IMotelService {
    public static IMotelDAO motelDAO = new MotelDAOImpl();

    @Override
    public void saveMotel(Motel motel) throws SQLException {
        motelDAO.saveMotel(motel);
    }

    @Override
    public Motel getMotelById(int id) throws SQLException {
        return motelDAO.getMotelById(id);
    }

    @Override
    public List<Motel> getAllMotel() throws SQLException {
        return motelDAO.getAllMotel();
    }

    @Override
    public boolean deleteMotel(int id) throws SQLException {
        return motelDAO.deleteMotel(id);
    }

    @Override
    public boolean updateMotel(int id, Motel motel) throws SQLException {
        return motelDAO.updateMotel(motel);
    }

    @Override
    public List<Motel> findByNameCustomer(String name) throws SQLException {
        return this.getAllMotel().stream().filter(Motel -> Motel.getName_customer().contains(name)).collect(Collectors.toList());
    }

    @Override
    public List<Motel> findByPhone(String phone) throws SQLException {
        return this.getAllMotel().stream().filter(Motel -> Motel.getPhone_number().contains(phone)).collect(Collectors.toList());
    }
}
