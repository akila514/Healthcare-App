package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PatientDao;
import entity.Doctor;
import entity.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientDaoImpl implements PatientDao {
    @Override
    public boolean save(Patient patient) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Patient VALUES(?,?,?,?)",patient.getPid(),patient.getName(),patient.getAddress(),patient.getContact());
    }

    @Override
    public boolean update(Patient patient) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Patient SET name=?, address=?, contact=? WHERE pId=?",patient.getName(),patient.getAddress(),patient.getContact(),patient.getPid());    }


    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Patient WHERE pId=?",s);
    }

    @Override
    public Patient get(String s) {
        return null;
    }



    @Override
    public ArrayList<Patient> getAllPatients() {
        return null;
    }
    public ArrayList<Patient> searchPatient(String text) throws SQLException, ClassNotFoundException {
        String searchText = "%"+text+"%";

        ResultSet rst=CrudUtil.execute("SELECT * FROM Patient WHERE address LIKE ? || name LIKE ? || contact LIKE ?",searchText,searchText,searchText);
        ArrayList<Patient> lst=new ArrayList<>();
        while(rst.next()){
            lst.add(new Patient(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return lst;
    }
}
