package com.school.school_registration;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class studentsDatesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Students> dateStudentsTable;

    @FXML
    private TableColumn<Students, String> students_date_table_address;

    @FXML
    private TableColumn<Students, String> students_date_table_id;

    @FXML
    private TableColumn<Students, String> students_date_table_class;

    @FXML
    private TableColumn<Students, String> students_date_table_country;

    @FXML
    private TableColumn<Students, String> students_date_table_dateBirth;

    @FXML
    private TableColumn<Students, String> students_date_table_date_Registration;

    @FXML
    private TableColumn<Students, String> students_date_table_email;

    @FXML
    private TableColumn<Students, String> students_date_table_gender;

    @FXML
    private TableColumn<Students, String> students_date_table_name;

    @FXML
    private TableColumn<Students, String> students_date_table_phone;

    @FXML
    private TableColumn<Students, String> students_date_table_surname;

    @FXML
    private TableColumn<Students, String> students_date_table_town;

    @FXML
    void initialize() {

        showDateStudents();

//        dateStudentsTable.setOnMouseClicked(mouseEvent -> {
//            System.out.println("click of tableview");
//            loadDateStudents();
//            dateStudentsTable.getScene().getWindow().hide();
//        });

    }


    private void showDateStudents(){
        DBHandler dbHandler = new DBHandler();

        ObservableList<Students> textField = dbHandler.showDateStudents();

        students_date_table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        students_date_table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        students_date_table_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        students_date_table_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        students_date_table_dateBirth.setCellValueFactory(new PropertyValueFactory<>("dateBirth"));
        students_date_table_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        students_date_table_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        students_date_table_country.setCellValueFactory(new PropertyValueFactory<>("country"));
        students_date_table_town.setCellValueFactory(new PropertyValueFactory<>("town"));
        students_date_table_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        students_date_table_class.setCellValueFactory(new PropertyValueFactory<>("classes"));
        students_date_table_date_Registration.setCellValueFactory(new PropertyValueFactory<>("dateRegistration"));

        dateStudentsTable.setItems(textField);
    }

//    private void loadDateStudents (){
//        studentsController loadDate = new studentsController();
//        ObservableList textField = (ObservableList) dateStudentsTable.getSelectionModel().getSelectedItems();
//
//        loadDate.students_name.setText(String.valueOf(textField));
//        loadDate.students_surname.setText((String) textField.get(2));
//        loadDate.students_birth.dayCellFactoryProperty();
//        loadDate.students_email.setText((String) textField.get(4));;;
//        loadDate.students_phone.setText((String) textField.get(5));;;
//        loadDate.students_country.setValue();
//        loadDate.students_town.setValue();
//        loadDate.students_address.setText((String) textField.get(8));;;
//        loadDate.students_class.setValue();
//        loadDate.students_date_registration.dayCellFactoryProperty();
//        loadDate.students_update_button.setDisable(false);
//        loadDate.students_clear_button.setDisable(false);
//        loadDate.students_info_button.setDisable(true);
//        loadDate.students_add_button.setDisable(true);
//    }
}





