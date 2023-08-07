package dao.custom;

import dao.CrudDao;
import entity.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DoctorDao extends CrudDao<Doctor,String> {
    public ArrayList<Doctor> searchDoctor(String text) throws SQLException, ClassNotFoundException;
}
