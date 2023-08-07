package controller;

import com.jfoenix.controls.JFXButton;
import dao.custom.impl.DoctorDaoImpl;
import dao.custom.impl.PatientDaoImpl;
import entity.Doctor;
import entity.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.DoctorTm;
import view.tm.PatientTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class PatientFormController {

    public TextField searchTxt;
    public JFXButton btnSavePatient;
    public TableView<PatientTm> tablePatient;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colOption;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;

    private String sText="";

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        searchData(sText);

        tablePatient.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                setData(newValue);
            }
        });

        searchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            sText=newValue;
            searchData(sText);
        });

    }
    private void searchData(String text) {
        try {
            ArrayList<Patient> lst=new PatientDaoImpl().searchPatient(text);
            ObservableList<PatientTm> tmList= FXCollections.observableArrayList();
            for(Patient d:lst){
                Button btn=new Button("Delete");
                tmList.add(new PatientTm(d.getPid(),d.getName(),d.getAddress(),d.getContact(),btn));
                btn.setOnAction(event -> {
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure?",ButtonType.YES,ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if(buttonType.get()==ButtonType.YES){
                        try {

                            if(new PatientDaoImpl().delete(d.getPid())){
                                searchData(sText);
                                new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
                            }else{
                                new Alert(Alert.AlertType.WARNING,"Try Again").show();

                            }
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

            }
            tablePatient.setItems(tmList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void btnNewPatientOnAction(ActionEvent actionEvent) {
        btnSavePatient.setText("Save Patient");
    }


    private void setData(PatientTm tm){
        btnSavePatient.setText("Update Patient");
        txtId.setText(tm.getId());
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContact());
    }
    public void SavePatientOnAction(ActionEvent actionEvent) {
        Patient d1=new Patient(txtId.getText(),txtName.getText(),txtAddress.getText(),txtContact.getText());

        if(btnSavePatient.getText().equals("Save Patient")){
            try {
                boolean isSaved=new PatientDaoImpl().save(d1);
                if(isSaved){
                    searchData(sText);
                    new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
                }else{
                    new Alert(Alert.AlertType.WARNING,"Try Again").show();

                }

            } catch (ClassNotFoundException | SQLException e) {
                new Alert(Alert.AlertType.ERROR,"Try Again").show();
                e.printStackTrace();
            }
        }else{
            try {
                boolean isUpdated=new PatientDaoImpl().update(d1);
                if(isUpdated){
                    searchData(sText);
                    new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                }else{
                    new Alert(Alert.AlertType.WARNING,"Try Again").show();

                }

            } catch (ClassNotFoundException | SQLException e) {
                new Alert(Alert.AlertType.ERROR,"Try Again").show();
                e.printStackTrace();
            }
        }
    }
}
