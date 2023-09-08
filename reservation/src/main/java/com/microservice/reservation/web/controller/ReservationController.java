package com.microservice.reservation.web.controller;


import com.microservice.reservation.dao.IReservationDAO;
import com.microservice.reservation.exceptions.ExceptionInputAge;
import com.microservice.reservation.model.Reservation;
import com.microservice.reservation.services.ReservationServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.microservice.reservation.services.ReservationServices.driverAge;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    //@Autowired
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

    @PostMapping("/{age}")
    public Reservation addNewReservation(@RequestBody Reservation reservation, int id, @PathVariable int age){
        if (driverAge(id)!=age || driverAge(id)<18){
            throw new ExceptionInputAge();
        }
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


    @PostMapping("/addPriceReser")
    public Reservation addPriceReservation(@RequestBody Reservation reservation,int id){
        reservation.setTotalPrice(ReservationServices.calculatePrice(id));
        return reservationDAO.save(reservation);
    }


    @GetMapping("/vehicleMaxHP/{age}")
    public Reservation getVehicleFilterAge(@PathVariable int age){
       ReservationServices.firstListVehicleFilterAge(age);
        return (Reservation) reservationDAO.findAll();
    }
}

//      @Query("SELECT  FROM Reservation r WHERE r.pick_up_date BETWEEN (:pickUpDesiredDate) AND (:returnDesiredDate) " +
//            "OR  r.return_date BETWEEN  (:pickUpDesiredDate) AND (:returnDesiredDate) " +
//            "OR r.pick_up_date < (:pickUpDesiredDate) AND r.return_date > (:returnDesiredDate)")
//    List<Integer> getBusyVehicleID(Date pickUpDesiredDate, Date returnDesiredDate) {
//        return null;
//    }





















