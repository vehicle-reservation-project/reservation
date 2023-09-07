package com.microservice.reservation.services;

import com.microservice.reservation.model.Driver;
import com.microservice.reservation.model.Reservation;
import com.microservice.reservation.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.getDriver;


@Service

public class ReservationServices {

    RestTemplate restTemplate = new RestTemplate();


    public Driver getDriver(int driver_id) {
        Driver driver = restTemplate.getForObject("http://192.168.1.251:8080/driver/" + driver_id, Driver.class);
        return driver;
    }

    public Vehicle getVehicle(int vehicle_id) {
        Vehicle vehicle = restTemplate.getForObject("http://192.168.1.249:8080/vehicle/" + vehicle_id, Vehicle.class);
        return vehicle;
    }


    public long driverAge(int id) {
        Date bornDate = getDriver(id).getBirthDate();
        Date today = new Date();
        long ageDriver = ChronoUnit.YEARS.between(bornDate.toInstant(),today.toInstant());
        return ageDriver;
    }



}
