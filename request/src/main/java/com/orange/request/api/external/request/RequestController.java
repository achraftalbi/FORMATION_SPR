package com.orange.request.api.external.request;

import com.orange.request.representation.request.RequestRepresentation;
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

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RequestRepresentation> searchRequestByNumber(@RequestParam(required = true) Long number){
        RequestRepresentation requestRepresentation = RequestRepresentation.builder()
                .number(65465l).build();
        return ResponseEntity.status(HttpStatus.OK).body(requestRepresentation);
    }
}
