package com.school.school_registration;

import java.sql.*;
import java.util.ArrayList;


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

    //----------------------------------------------------------------------------------------------------------------

    public ArrayList<String> getCountry (){
        ResultSet resultSet = null;
        ArrayList <String> listCountries = new ArrayList<>();

        String select = "SELECT * FROM " + Constants.COUNTRIES;

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            resultSet = prST.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            while (resultSet.next()){
                listCountries.add(resultSet.getString("nameCountry"));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listCountries;
    }

    //--------------------------------------------------------------------------------------------------------------
    public ArrayList<String> getTown () {
        ResultSet resultSet = null;
        ArrayList<String> listTowns = new ArrayList<>();

        //String primKeyCountries = studentsController();

        String select = "SELECT * FROM " + Constants.TOWNS + " WHERE "
                                         + Constants.FK_ID_COUNTRY + "=' " + "2" + " ' ";

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            resultSet = prST.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            while (resultSet.next()) {
                listTowns.add(resultSet.getString("nameTown"));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listTowns;
    }

    //---------------------------------------------------------------------------------------------------------------

    public void registerStudents(Students student){
        ResultSet resultSet = null;

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


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //---------------------------------------------------------------------------------------------------------------







}
