package com.smartconf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Lenovo on 2017-01-15.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConferenceDayNotFoundException extends RuntimeException {
    public ConferenceDayNotFoundException(Long id) {
        super("Could not find conference day with id:"+id+".");
    }
}
