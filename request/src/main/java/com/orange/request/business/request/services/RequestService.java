package com.orange.request.business.request.services;

import com.orange.request.exceptions.request.RequestNotFoundException;
import com.orange.request.representation.request.RequestRepresentation;

public interface RequestService {
    RequestRepresentation searchRequestNumber(Long number) throws RequestNotFoundException;
}
