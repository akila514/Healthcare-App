package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {

    public AnchorPane DashBoardData;

    public void DoctorFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DoctorForm");
    }
    public void initialize() throws IOException {

        setUi("DefaultForm");
       /* Stage stage= (Stage) DashBoardData.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DefaultForm.fxml"))));*/
    }
    private void setUi(String value) throws IOException {
        DashBoardData.getChildren().clear();
        DashBoardData.getChildren().add(
                FXMLLoader.load(
                        getClass().
                                getResource("../view/"+value+".fxml")
                )
        );
    }

    public void PatientFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PatientForm");
    }
}
