package com.school.school_registration;

import java.net.URL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

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
    private Button students_save_button;

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
            registerStudentsUp();
        });

        //-------------------------------------------------


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
        Callback<DatePicker, DateCell> dateBirth = students_birth.getDayCellFactory();
        String email = students_email.getText();
        String phone = students_phone.getText();
        String country = (String) students_country.getValue();
        String town = (String) students_town.getPromptText();
        String address = students_address.getText();
        String classes = (String) students_class.getPromptText();
        Callback<DatePicker, DateCell> dateRegistration = students_date_registration.getDayCellFactory();

        if (students_gender_male.isSelected())
            gender = "Male";
        else
            gender = "Female";

        Students student = new Students (name, surname, gender, (DatePicker) dateBirth,
                                         email, phone, country, town, address, classes,
                                         (DatePicker) dateRegistration);
        dbHandler.registerStudents(student);
        }

     //--------------------------------------------------------------------------------------------------------------


    }

