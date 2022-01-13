package com.orange.request.exceptions.generic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FoundException extends Exception{
    public FoundException(String message) {
        super(message);
    }
}
