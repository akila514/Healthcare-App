package dao.custom;

import dao.CrudDao;
import entity.Doctor;
import entity.Patient;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PatientDao extends CrudDao<Patient,String> {
    public ArrayList<Patient> searchPatient(String text) throws SQLException, ClassNotFoundException;

}
