package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.DoctorDao;
import entity.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDaoImpl implements DoctorDao {

    @Override
    public boolean save(Doctor doctor) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Doctor VALUES(?,?,?,?)",doctor.getDid(),doctor.getName(),doctor.getAddress(),doctor.getContact());
    }

    @Override
    public boolean update(Doctor doctor) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Doctor SET name=?, address=?, contact=? WHERE dId=?",doctor.getName(),doctor.getAddress(),doctor.getContact(),doctor.getDid());    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Doctor WHERE dId=?",s);
    }

    @Override
    public Doctor get(String s) {
        return null;
    }

    @Override
    public ArrayList<Doctor> getAllPatients() {
        return null;
    }


    @Override
    public ArrayList<Doctor> searchDoctor(String text) throws SQLException, ClassNotFoundException {
        String searchText = "%"+text+"%";

        ResultSet rst=CrudUtil.execute("SELECT * FROM Doctor WHERE address LIKE ? || name LIKE ? || contact LIKE ?",searchText,searchText,searchText);
        ArrayList<Doctor> lst=new ArrayList<>();
        while(rst.next()){
            lst.add(new Doctor(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return lst;
    }
}
