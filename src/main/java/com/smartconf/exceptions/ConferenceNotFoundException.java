package com.smartconf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Lenovo on 2017-01-02.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConferenceNotFoundException extends RuntimeException {
    public ConferenceNotFoundException(Long id) {
        super("Could not find the conference with id "+id+".");
    }
}
