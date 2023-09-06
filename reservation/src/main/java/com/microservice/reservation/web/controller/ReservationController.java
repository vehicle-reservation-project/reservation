package com.microservice.reservation.web.controller;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.microservice.reservation.dao.IReservationDAO;
import com.microservice.reservation.exceptions.ExceptionsReservation;
import com.microservice.reservation.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private IReservationDAO reservationDAO;
    @GetMapping
    public Object listALLReservations(){
        Iterable<Reservation> reservations = reservationDAO.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue reservationsFiltres = new MappingJacksonValue(reservations);

        reservationsFiltres.setFilters(listDeNosFiltres);

        return reservationsFiltres;
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

    public void checkReservationInput(Reservation reservation){
        if ((reservation.getPickUpDate().equals(""))||( reservation.getReturnDate().equals(""))){
            throw new ExceptionsReservation();
        }
    }


}



















