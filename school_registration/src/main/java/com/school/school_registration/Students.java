package com.school.school_registration;



public class Students {



    private String id;
    private String name;
    private String surname;
    private String gender;
    private String dateBirth;
    private String email;
    private String phone;
    private String country;
    private String town;
    private String address;
    private String classes;
    private String dateRegistration;

    public Students (String name, String surname, String gender, String dateBirth, String email,
                    String phone, String country, String town, String address, String classes,
                    String dateRegistration) {

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



    public Students (String id, String name, String surname, String gender, String dateBirth, String email,
                    String phone, String country, String town, String address, String classes, String dateRegistration) {
        this.id = id;
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


    public String getId() {
        return id;
        }
    public void setId(String id) {
        this.id = id;
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

    public String getDateBirth() {return dateBirth;}

    public void setDateBirth(String dateBirth) {
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

    public String getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(String dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
