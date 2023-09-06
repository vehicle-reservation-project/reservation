package com.microservice.reservation.services;

import com.microservice.reservation.model.Driver;
import com.microservice.reservation.model.Vehicle;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Service
@RestController
@RequestMapping("/reservation")
public class ReservationServices {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/driver")
    public Object getDrivers(int driver_id) {
        Driver drivers = restTemplate.getForObject("http://192.168.1.251:8080/driver/" + driver_id, Driver.class);
        return drivers;
    }

    @GetMapping("/vehicle")
    public Object getVehicles(int vehicle_id) {
      Vehicle vehicles = restTemplate.getForObject("http://192.168.1.249:8080/vehicle/" + vehicle_id, Vehicle.class);
        return vehicles;
    }
}
