package com.school.school_registration;

import javafx.scene.control.DatePicker;

import java.util.Date;

public class Students {

    private String name;
    private String surname;
    private String gender;
    private DatePicker dateBirth;
    private String email;
    private String phone;
    private String country;
    private String town;
    private String address;
    private String classes;
    private DatePicker dateRegistration;

    public Students(String name, String surname, String gender, DatePicker dateBirth, String email,
                    String phone, String country, String town, String address, String classes,
                    DatePicker dateRegistration) {

        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.town = town;
        this.address = address;
        this.classes = classes;
        this.dateRegistration = dateRegistration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DatePicker getDateBirth() {return dateBirth;}

    public void setDateBirth(DatePicker dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public DatePicker getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(DatePicker dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
