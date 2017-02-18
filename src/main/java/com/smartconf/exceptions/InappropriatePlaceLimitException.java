package com.smartconf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Lenovo on 2017-01-15.
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InappropriatePlaceLimitException extends RuntimeException {
    public InappropriatePlaceLimitException() {
        super("Inappropriate place limit number");
    }

    public InappropriatePlaceLimitException(Integer number) {
        super("Inappropriate place limit number. Place limit must be greater or equal "+number);
    }
}
