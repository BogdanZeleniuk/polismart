package com.insurance.polismart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Admin on 01.09.2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No data was found")
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}