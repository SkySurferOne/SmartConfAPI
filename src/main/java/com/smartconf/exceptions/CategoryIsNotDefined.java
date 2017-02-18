package com.smartconf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Lenovo on 2017-01-02.
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class CategoryIsNotDefined extends RuntimeException {
    public CategoryIsNotDefined() {
        super("Category object is not defined");
    }
}
