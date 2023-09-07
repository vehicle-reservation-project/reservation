package com.microservice.reservation.services;

import com.microservice.reservation.model.Driver;
import com.microservice.reservation.model.Vehicle;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service

public class ReservationServices {

    RestTemplate restTemplate = new RestTemplate();


    public Object getDriver(int driver_id) {
        Driver driver = restTemplate.getForObject("http://192.168.1.251:8080/driver/" + driver_id, Driver.class);
        return driver;
    }

    public Object getVehicle(int vehicle_id) {
      Vehicle vehicle = restTemplate.getForObject("http://192.168.1.249:8080/vehicle/" + vehicle_id, Vehicle.class);
        return vehicle;
    }

    public void calculatePriceCar(Vehicle vehicle, int id){
        getVehicle(id);
        int priceCar = getVehicle(id).get


    }
}
