package com.school.school_registration;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    //---------------------------------------------------------------------------------------------------------------

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

        public ArrayList<String> getClassRooms(){
            ResultSet resultSet = null;
            ArrayList<String> listClassRooms = new ArrayList<>();

            String select = "SELECT * FROM " + Constants.CLASS;


            try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            resultSet = prST.executeQuery();

            } catch (SQLException | ClassNotFoundException e){
                throw new RuntimeException(e);
            }

            try {
                while (resultSet.next()){
                    listClassRooms.add(resultSet.getString( "nameClass"));
                }
                resultSet.close();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
            return listClassRooms;
        }


    //---------------------------------------------------------------------------------------------------------------

    public void registerStudents(Students student){

        String insert = " INSERT INTO " + Constants.STUDENTS + "("
                                        + Constants.STUDENTS_NAME + "," + Constants.STUDENTS_SURNAME + ","
                                        + Constants.STUDENTS_GENDER + "," + Constants.STUDENTS_DATE_BIRTH + ","
                                        + Constants.STUDENTS_EMAIL + "," + Constants.STUDENTS_PHONE + ","
                                        + Constants.STUDENTS_COUNTRY + "," + Constants.STUDENTS_TOWN + ","
                                        + Constants.STUDENTS_ADDRESS + "," + Constants.STUDENTS_CLASSES + ","
                                        + Constants.STUDENTS_DATE_REGISTRATION + ")"
                                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString( 1, student.getName());
            prSt.setString( 2, student.getSurname());
            prSt.setString( 3, student.getGender());
            prSt.setString( 4, student.getDateBirth());
            prSt.setString( 5, student.getEmail());
            prSt.setString( 6, student.getPhone());
            prSt.setString( 7, student.getCountry());
            prSt.setString( 8, student.getTown());
            prSt.setString( 9, student.getAddress());
            prSt.setString( 10, student.getClasses());
            prSt.setString( 11, student.getDateRegistration());
            prSt.executeUpdate();

            prSt.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //---------------------------------------------------------------------------------------------------------------

        public ObservableList<Students> showDateStudents () {
            ResultSet resultSet = null;
            ObservableList<Students> obsList = FXCollections.observableArrayList();


            String select = "SELECT* FROM " + Constants.STUDENTS;


            try {

                PreparedStatement prST = getDbConnection().prepareStatement(select);
                resultSet = prST.executeQuery();

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {

                while (resultSet.next()){
                        obsList.add(new Students(resultSet.getString( "idstudents"),
                                                resultSet.getString( "students_name"),
                                                resultSet.getString(  "students_surname" ),
                                                resultSet.getString( "students_gender"),
                                                resultSet.getString( "students_dateBirth"),
                                                resultSet.getString( "students_email"),
                                                resultSet.getString( "students_phone"),
                                                resultSet.getString( "students_country"),
                                                resultSet.getString( "students_town"),
                                                resultSet.getString( "students_address"),
                                                resultSet.getString( "students_classes"),
                                                resultSet.getString( "students_dateRegistration")));

                }
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return obsList;
        }

    //---------------------------------------------------------------------------------------------------------------









}
