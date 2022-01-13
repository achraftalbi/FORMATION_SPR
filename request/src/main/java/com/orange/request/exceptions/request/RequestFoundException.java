package com.orange.request.exceptions.request;

import com.orange.request.exceptions.generic.FoundException;
import com.orange.request.exceptions.generic.NotFoundException;

public class RequestFoundException extends FoundException {
    public RequestFoundException(String message) {
        super(message);
    }
}
