package com.smartconf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Lenovo on 2017-01-02.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
    // TODO make more general exceptions for ex. ObjectNotFoundException
    public CategoryNotFoundException(String categoryName) {
        super("Could not find category "+categoryName+".");
    }
    public CategoryNotFoundException(Long id) {
        super("Could not find category with id: "+id+".");
    }
}
