package com.microservice.reservation.web.controller;


import com.microservice.reservation.dao.IReservationDAO;
import com.microservice.reservation.model.Reservation;
import com.microservice.reservation.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import static java.sql.DriverManager.getDriver;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    public IReservationDAO reservationDAO;

    public Reservation reservation;
    @GetMapping
    public List<Reservation> listALLReservations(){
        List<Reservation> reservations = reservationDAO.findAll();
        return reservations;
    }


    @GetMapping("/{id}")
    public Reservation listOneReservation(@PathVariable int id){
          return reservationDAO.findById(id);
    }

    @PostMapping
    public Reservation addNewReservation(@RequestBody Reservation reservation){
        return reservationDAO.save(reservation);
    }

    @PutMapping
    public Reservation editReservation(@RequestBody Reservation reservation, @PathVariable int id){
        reservation.setId(id);
        return reservationDAO.save(reservation);
    }

    @DeleteMapping("/{id}")
    public Reservation deleteReservation(@PathVariable int id){
        return reservationDAO.deleteById(id);
    }

//    public void checkReservationInput(Reservation reservation){
//        if ((reservation.getPickUpDate().equals(""))||( reservation.getReturnDate().equals(""))){return_date
//            throw new ExceptionsReservation();
//        }
//    }

    @PostMapping("/addPriceReser")
    public Reservation addPriceReservation(@RequestBody Reservation reservation,int id){
        reservation.setTotalPrice(ReservationServices.calculatePrice(id));
        return reservationDAO.save(reservation);
    }












}



















