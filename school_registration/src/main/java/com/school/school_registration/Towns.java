package com.school.school_registration;

public class Towns {
    private String nameTown;
    private String foreignTown;


    public Towns () {

    }

    public Towns(String nameTown, String foreignTown) {
        this.nameTown = nameTown;
        this.foreignTown = foreignTown;
    }

    public String getNameTown() {
        return nameTown;
    }

    public void setNameTown(String nameTown) {
        this.nameTown = nameTown;
    }

    public String getForeignTown() {
        return foreignTown;
    }

    public void setForeignTown(String foreignTown) {
        this.foreignTown = foreignTown;
    }
}
