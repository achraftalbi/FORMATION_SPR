package com.orange.request.exceptions.request;

import com.orange.request.exceptions.generic.NotFoundException;

public class RequestNotFoundException extends NotFoundException {
    public RequestNotFoundException(String message) {
        super(message);
    }
}
