package com.microservice.reservation.services;

import com.microservice.reservation.model.Driver;
import com.microservice.reservation.model.Reservation;
import com.microservice.reservation.model.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;


@Service


public class ReservationServices {
    public static double priceKmCar = 0.05;

    static RestTemplate restTemplate = new RestTemplate();

    public static Reservation reservation;



    public static Driver getDriver(int driver_id) {
        Driver driver = restTemplate.getForObject("http://192.168.1.251:8080/driver/" + driver_id, Driver.class);
        return driver;
    }

    public static Vehicle getVehicle(int vehicle_id) {
        Vehicle vehicle = restTemplate.getForObject("http://192.168.1.249:8080/vehicle/" + vehicle_id, Vehicle.class);
        return vehicle;
    }
    public static Vehicle[] getVehicleMaxHp(int fiscalHPower){
        ResponseEntity<Vehicle[]> response = restTemplate.getForEntity("http://192.168.1.249:8080/vehicle/"+ fiscalHPower, Vehicle[].class);
        Vehicle[] vehicles = response.getBody();
        return  vehicles;
    }


    public static double calculatePrice(int id) {
        double price;
        if (getVehicle(id).getType().equals("car")) {
            price = getVehicle(id).getPriceDay() + priceKmCar * reservation.getEstimatedKm()
                    * getVehicle(id).getDisplacementMotorcycleCm3() * 0.001;
        } else if (getVehicle(id).getType().equals("moto")) {
            price = getVehicle(id).getPriceDay() + priceKmCar * reservation.getEstimatedKm()
                    * getVehicle(id).getDisplacementMotorcycleCm3() * 0.001;
        } else {
            price = getVehicle(id).getPriceDay() + 0.05 * reservation.getEstimatedKm() *
                    priceKmCar * getVehicle(id).getLoadCapacityM3();
        }
        return price;
    }
    public static long driverAge(int id) {
        Date bornDate = getDriver(id).getBirthDate();
        Date today = new Date();
        long ageDriver = ChronoUnit.YEARS.between(bornDate.toInstant(),today.toInstant());
        return ageDriver;
    }



    public static List<Vehicle> firstListVehicleFilterAge(int age){
        List<Vehicle> vehicles;
        if (age<21 && age>18){
            vehicles = List.of(getVehicleMaxHp(8));
        } else if (age<25 && age>21){
            vehicles = List.of(getVehicleMaxHp(13));
        } else {
            vehicles = List.of(getVehicleMaxHp(15));
        }
        return vehicles;
    }
    public static List<Vehicle> listAvailableVehicles(Date enterDate, Date exitDate){
        List<Vehicle> availableVehicles;
//
//        for (Integer id: reservation){
//            if (id == getBusyVehicleID(reservation.setPickUpDate(enterDate), reservation.setReturnDate(exitDate))){
//                getVehicle(id);
//            }
//        }

return null;

    }








//    public static List<Vehicle> firstListVehicleFilterAge(int id){
//        int age = (int) driverAge(id);
//        List<Vehicle> vehicles;
//        if (age<21 && age>18){
//            vehicles = List.of(getVehicleMaxHp(8));
//        } else if (age<25 && age>21){
//            vehicles = List.of(getVehicleMaxHp(13));
//        } else {
//            vehicles = List.of(getVehicleMaxHp(15));
//        }
//        return vehicles;
//    }








}














