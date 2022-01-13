package com.orange.request.business.request.impl;

import com.orange.request.business.request.services.RequestService;
import com.orange.request.data.model.Request;
import com.orange.request.data.model.RequestRepository;
import com.orange.request.exceptions.request.RequestNotFoundException;
import com.orange.request.representation.request.RequestRepresentation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestServiceImpl(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    RequestRepository requestRepository;

    @Override
    public RequestRepresentation searchRequestNumber(Long number) throws RequestNotFoundException {

        Optional<Request> request = requestRepository.findByNumber(number);

        if(request.isEmpty()){
            log.error("This request with number {} doesn't exit", number);
            throw new RequestNotFoundException("REQ_NOT_FOUND_678");
        }


        RequestRepresentation requestRepresentation = RequestRepresentation.builder()
                .number(request.get().getNumber()).status(request.get().getStatus())
                .type(request.get().getType()).description(request.get().getDescription())
                .username(request.get().getUsername()).build();

        return requestRepresentation;
    }

}
