package com.microservice.reservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionsReservation extends ResponseStatusException {
     public ExceptionsReservation(){
        super(HttpStatus.NOT_FOUND, "your entry is not valid!");
        }
}
