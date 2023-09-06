package com.microservice.reservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
private Integer id;
private Date pickUpDate;
private Date returnDate;
private Integer driver_id;
private Integer vehicle_id;

    public Reservation(Integer id, Date pickUpDate, Date returnDate, Integer driver_id, Integer vehicle_id) {
        this.id = id;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.driver_id = driver_id;
        this.vehicle_id = vehicle_id;
    }
    public Reservation(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", pickUpDate=" + pickUpDate +
                ", returnDate=" + returnDate +
                ", driver_id=" + driver_id +
                ", vehicle_id=" + vehicle_id +
                '}';
    }
}
