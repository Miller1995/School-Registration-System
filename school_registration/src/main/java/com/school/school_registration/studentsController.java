package com.school.school_registration;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class studentsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button students_delete_button;

    @FXML
    private Button students_add_button;

    @FXML
    private TextField students_address;

    @FXML
    private DatePicker students_birth;

    @FXML
    private ComboBox<?> students_class;

    @FXML
    private ComboBox<?> students_country;

    @FXML
    private DatePicker students_date_registration;

    @FXML
    private TextField students_email;

    @FXML
    private RadioButton students_gender_female;

    @FXML
    private RadioButton students_gender_male;

    @FXML
    private Button students_info_button;

    @FXML
    private TextField students_name;

    @FXML
    private TextField students_phone;

    @FXML
    private Button students_clear_button;

    @FXML
    private TextField students_surname;

    @FXML
    private ComboBox<?> students_town;

    @FXML
    private Button students_update_button;

    @FXML
    void initialize() {

        //----------------------------------------------

        students_country.setOnShown (event -> {
            System.out.println("Countries show");
        });
            getCountry();

        //-----------------------------------------------

        students_town.setOnShown(event -> {
            System.out.println("Town show");
        });
            getTown();

        //------------------------------------------------

        students_add_button.setOnAction(event -> {
            System.out.println("Press button add");
            registerStudentsUp();
        });

        //-------------------------------------------------

        students_class.setOnShown(event -> {
            System.out.println("Class show");
        });
            getClassRooms();

        //-------------------------------------------------

        students_clear_button.setOnAction(event -> {
            System.out.println("Press button clear");
            clearStudentsTextField();
        });

        //-------------------------------------------------

        students_info_button.setOnAction(event -> {
            students_info_button.getScene().getWindow();
            openNewWindows("students_dates.fxml");
        });

        //-------------------------------------------------

        students_update_button.setDisable(true);

        //-------------------------------------------------

        students_delete_button.setDisable(true);

        //-------------------------------------------------
    }


    private void getClassRooms() {
        DBHandler dbHandler = new DBHandler();

        ArrayList<String> dbCountries =  dbHandler.getClassRooms();
        students_class.getItems().addAll((Collection)dbCountries);
    }

    //---------------------------------------------------------------------------------------------------------------
    private void getCountry() {
        DBHandler dbHandler = new DBHandler();

        ArrayList<String> dbCountries =  dbHandler.getCountry();
        students_country.getItems().addAll((Collection)dbCountries);

    }

    //---------------------------------------------------------------------------------------------------------------

    private void getTown(){
        DBHandler dbHandler = new DBHandler();

        ArrayList<String> dbTowns = dbHandler.getTown();
        students_town.getItems().addAll((Collection)dbTowns);
    }

    //---------------------------------------------------------------------------------------------------------------
    private void registerStudentsUp(){
        DBHandler dbHandler = new DBHandler();

          String name = students_name.getText();
          String surname = students_surname.getText();
          String gender = "";
          String dateBirth = String.valueOf(students_birth.getValue());
          String email = students_email.getText();
          String phone = students_phone.getText();
          String country = (String) students_country.getValue();
          String town = (String) students_town.getValue();
          String address = students_address.getText();
          String classes = (String) students_class.getValue();
          String dateRegistration = String.valueOf(students_date_registration.getValue());

          if (students_gender_male.isSelected())
              gender = "Male";
          else
              gender = "Female";

          Students student = new Students(name, surname, gender, dateBirth,
                  email, phone, country, town, address, classes, dateRegistration);
          dbHandler.registerStudents(student);
      }

     //--------------------------------------------------------------------------------------------------------------
    private void clearStudentsTextField(){

            students_name.clear();
            students_surname.clear();
            students_email.clear();
            students_birth.setValue(null);
            students_phone.clear();
            students_country.setValue(null);
            students_town.setValue(null);
            students_address.clear();
            students_class.setValue(null);
            students_date_registration.setValue(null);

    }

    //--------------------------------------------------------------------------------------------------------------
    public void openNewWindows(String window){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Students Dates");
        stage.showAndWait();
    }

    //--------------------------------------------------------------------------------------------------------------



    //--------------------------------------------------------------------------------------------------------------


    }

