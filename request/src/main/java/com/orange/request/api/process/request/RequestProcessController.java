package com.orange.request.api.process.request;

import com.orange.request.business.process.camunda.services.TaskCamundaService;
import com.orange.request.business.process.request.services.ProcessRequestService;
import com.orange.request.exceptions.request.RequestFoundException;
import com.orange.request.representation.process.ResponseProcessRepresentation;
import com.orange.request.representation.process.TaskRepresentation;
import com.orange.request.representation.request.RequestRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/process/request")
public class RequestProcessController {

    @Autowired
    RequestProcessController(ProcessRequestService processRequestService){
        this.processRequestService = processRequestService;
    }

    ProcessRequestService processRequestService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseProcessRepresentation createRequestProcess(@RequestBody RequestRepresentation requestRepresentation) throws RequestFoundException {

        return processRequestService.createRequestProcess(requestRepresentation);
    }

}
