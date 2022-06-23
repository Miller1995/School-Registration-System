package com.school.school_registration;

import javafx.collections.FXCollections;

import java.sql.*;


public class DBHandler extends ConfigsDB {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{

    String connectionString = "jdbc:mysql://" + dbHost + ":" +
             dbPort + "/" +dbName;

    Class.forName("com.mysql.jdbc.Driver");
    dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }


    public ResultSet getCountry (Countries country){
        ResultSet getcountry = null;

        String select = "SELECT * FROM" + Constants.COUNTRIES;

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setString(1, country.getNameCountry());
            getcountry = prST.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return getcountry ;
    }

    public void registerStudents(Students student){

        String insert = " INSERT INTO " + Constants.STUDENTS + "("
                                        + Constants.STUDENTS_NAME + "," + Constants.STUDENTS_SURNAME + ","
                                        + Constants.STUDENTS_GENDER + "," + Constants.STUDENTS_DATE_BIRTH + ","
                                        + Constants.STUDENTS_EMAIL + "," + Constants.STUDENTS_PHONE+ ","
                                        + Constants.STUDENTS_COUNTRY + "," + Constants.STUDENTS_TOWN + ","
                                        + Constants.STUDENTS_ADDRESS + "," + Constants.STUDENTS_CLASSES + ","
                                        + Constants.STUDENTS_DATE_REGISTRATION + ")"
                                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString( 1, student.getName());
            prSt.setString( 2, student.getSurname());
            prSt.setString( 3, student.getGender());
            prSt.setString( 4, String.valueOf(student.getDateBirth()));
            prSt.setString( 5, student.getEmail());
            prSt.setString( 6, student.getPhone());
            prSt.setString( 7, student.getCountry());
            prSt.setString( 8, student.getTown());
            prSt.setString( 9, student.getAddress());
            prSt.setString( 10, student.getClasses());
            prSt.setString( 11, String.valueOf(student.getDateRegistration()));
            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }







}
