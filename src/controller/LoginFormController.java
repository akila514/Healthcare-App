package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane LoginContent;

    public void SignUpOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUpForm");
    }

    public void SignInOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashBoardForm");
    }
    private void setUi(String value) throws IOException {
        Stage stage= (Stage) LoginContent.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+value+".fxml"))));
    }
}
