package com.microservice.reservation.dao;

import com.microservice.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationDAO extends JpaRepository<Reservation, Integer> {
    Reservation save(Reservation reservation);

    Reservation findById(int id);

    Reservation deleteById(int id);

    @Query("SELECT r.id FROM Reservation r WHERE r.pickUpDate BETWEEN (:pickUpDesiredDate) AND (:returnDesiredDate) " +
            "OR  r.returnDate BETWEEN  (:pickUpDesiredDate) AND (:returnDesiredDate) " +
            "OR r.pickUpDate < (:pickUpDesiredDate) AND r.returnDate > (:returnDesiredDate)")
    List<Integer> getBusyVehicleID(@Param("pickUpDesiredDate") Date pickUpDesiredDate, @Param("returnDesiredDate") Date returnDesiredDate) ;
}


