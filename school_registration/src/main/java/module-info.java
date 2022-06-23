module com.school.school_registration {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.school.school_registration to javafx.fxml;
    exports com.school.school_registration;
}