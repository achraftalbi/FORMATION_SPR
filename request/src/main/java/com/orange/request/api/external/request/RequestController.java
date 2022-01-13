package com.orange.request.api.external.request;

import com.orange.request.business.request.services.RequestService;
import com.orange.request.exceptions.request.RequestNotFoundException;
import com.orange.request.representation.request.RequestRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/request")
public class RequestController {

    @Autowired
    RequestController(RequestService requestService){
        this.requestService = requestService;
    }

    RequestService requestService;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RequestRepresentation> searchRequestByNumber(@RequestParam(required = true) Long number)
            throws RequestNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(requestService.searchRequestNumber(number));
    }
}
