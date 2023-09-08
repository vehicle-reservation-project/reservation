package com.microservice.reservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionInputAge extends ResponseStatusException {
    public ExceptionInputAge() {
        super(HttpStatus.NOT_FOUND, "your age is not valid!");
    }
}
