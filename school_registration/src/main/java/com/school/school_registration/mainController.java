package com.school.school_registration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class mainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button main_admin_button;

    @FXML
    private Button main_login_button;

    @FXML
    private Button main_reports_button;

    @FXML
    private Button main_students_button;

    @FXML
    private Button main_taxes_button;

    @FXML
    private Button main_teachers_button;

    @FXML
    void initialize() {

        main_students_button.setOnAction(event -> {
            main_students_button.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/school/school_registration/students_page.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Data Processing");
            stage.showAndWait();
        });


    }

}