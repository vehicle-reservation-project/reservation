package com.microservice.reservation.dao;

import com.microservice.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationDAO extends JpaRepository<Reservation, Integer> {
Reservation findById(int id);
Reservation save(Reservation reservation);
Reservation deleteById(int id);
}
