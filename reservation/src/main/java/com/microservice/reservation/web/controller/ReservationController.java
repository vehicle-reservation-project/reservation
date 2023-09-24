package com.microservice.reservation.web.controller;

import com.microservice.reservation.dao.IReservationDAO;
import com.microservice.reservation.model.Reservation;
import com.microservice.reservation.model.Vehicle;
import com.microservice.reservation.services.ReservationServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")

public class ReservationController {
    //@Autowired
    public IReservationDAO reservationDAO;

    public Reservation reservation;

    @GetMapping
    public List<Reservation> listALLReservations() {
        List<Reservation> reservations = reservationDAO.findAll();
        return reservations;
    }


    @GetMapping("/{id}")
    public Reservation listOneReservation(@PathVariable int id) {
        return reservationDAO.findById(id);
    }

  //  @PostMapping("/{age}")
    //public Reservation addNewReservation(@RequestBody Reservation reservation, int id, @PathVariable int age) {
      //  if (driverAge(id) != age || driverAge(id) < 18) {
        //    throw new ExceptionInputAge();
        //}
        //return reservationDAO.save(reservation);
    //}

    @GetMapping("/availableVehicle/{age}/{type}/{pickUpDate}/{returnDate}")
    public List<Vehicle> listAvailableVehicles(@PathVariable int age, @PathVariable String type, @PathVariable Date pickUpDate, @PathVariable Date returnDate) {
        List<Integer> notValidId = reservationDAO.getBusyVehicleID(pickUpDate, returnDate);
        List<Vehicle> allVehicules = Arrays.stream(ReservationServices.getAllVehicles()).toList();
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : allVehicules) {
            if (!notValidId.contains(vehicle.getId())){
                if (vehicle.getType().equals(type)){
                    if (age<21 && age>=18 && vehicle.getFiscalHPower() < 8){
                        availableVehicles.add(vehicle);
                    }
                    if (age<25 && age>=21 && vehicle.getFiscalHPower() < 13){
                        availableVehicles.add(vehicle);
                    }
                    if(age>=25) {
                        availableVehicles.add(vehicle);
                    }
                }
            }
        }
        return availableVehicles;
    }

    @PutMapping
    public Reservation editReservation(@RequestBody Reservation reservation, @PathVariable int id) {
        reservation.setId(id);
        return reservationDAO.save(reservation);
    }

    @DeleteMapping("/{id}")
    public Reservation deleteReservation(@PathVariable int id) {
        return reservationDAO.deleteById(id);
    }

    @PostMapping("/addPriceReser")
    public Reservation addPriceReservation(@RequestBody Reservation reservation, int id) {
        reservation.setTotalPrice(ReservationServices.calculatePrice(id));
        return reservationDAO.save(reservation);
    }









    //@GetMapping("/vehicleMaxHP/{age}")
    //public Reservation getVehicleFilterAge(@PathVariable int age) {
    //    ReservationServices.firstListVehicleFilterAge(age);
      //  return (Reservation) reservationDAO.findAll();
    //}

}


















