package com.microservice.reservation.model;

import java.util.Date;



public class Driver {

    private Integer id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String licenseid;
    private Date licenseissueDate;



    public Driver(Integer id, String lastName, String firstName, Date birthDate, String licenseid, Date licenseissueDate) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.licenseid = licenseid;
        this.licenseissueDate = licenseissueDate;
    }

    public Driver() {

    }


    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public Date getLicenseissueDate() {
        return licenseissueDate;
    }

    public void setLicenseissueDate(Date licenseissueDate) {
        this.licenseissueDate = licenseissueDate;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", licenseid='" + licenseid + '\'' +
                ", licenseissueDate='" + licenseissueDate + '\'' +
                '}';
    }
}
