package com.orange.request.business.process.request.services;

import com.orange.request.exceptions.request.RequestFoundException;
import com.orange.request.representation.process.ResponseProcessRepresentation;
import com.orange.request.representation.process.TaskRepresentation;
import com.orange.request.representation.request.RequestRepresentation;

import java.util.List;

public interface ProcessRequestService {
    ResponseProcessRepresentation createRequestProcess(RequestRepresentation requestRepresentation) throws RequestFoundException;
}
