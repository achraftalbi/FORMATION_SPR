package com.orange.request.business.process.request.impl;

import camundajar.impl.scala.collection.immutable.Stream;
import com.orange.request.business.process.camunda.services.TaskCamundaService;
import com.orange.request.business.process.request.services.ProcessRequestService;
import com.orange.request.data.mapping.request.RequestMapper;
import com.orange.request.data.model.Request;
import com.orange.request.data.model.RequestRepository;
import com.orange.request.enums.RequestStatusEnum;
import com.orange.request.exceptions.request.RequestFoundException;
import com.orange.request.representation.process.ResponseProcessRepresentation;
import com.orange.request.representation.process.TaskRepresentation;
import com.orange.request.representation.request.RequestRepresentation;
import com.orange.request.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class ProcessRequestServiceImpl implements ProcessRequestService {

    @Autowired
    ProcessRequestServiceImpl(RuntimeService runtimeService, RequestRepository requestRepository){

        this.runtimeService = runtimeService;
        this.requestRepository = requestRepository;
    }

    RuntimeService runtimeService;
    RequestRepository requestRepository;


    @Override
    public ResponseProcessRepresentation createRequestProcess(RequestRepresentation requestRepresentation) throws RequestFoundException {

        Optional<Request> requestOptional = requestRepository.findByNumber(requestRepresentation.getNumber());
        Map<String, Object> variables = new HashMap<String, Object>();

        if(!requestOptional.isEmpty()){
            log.error("Request number {} already exist.", requestRepresentation.getNumber());
            throw new RequestFoundException("REQUEST_REQUEST_100");
        }
        requestRepresentation.setStatus(RequestStatusEnum.START.name());
        Request request = RequestMapper.fromRequestRepresentation(requestRepresentation);
        requestRepository.save(request);

        variables.put(Constants.BUSINESS_KEY, requestRepresentation.getNumber());
        runtimeService.startProcessInstanceByKey(Constants.REQUEST_PROCESS, Constants.BUSINESS_KEY, variables);

        return ResponseProcessRepresentation.builder().
                process(Constants.REQUEST_PROCESS).status(RequestStatusEnum.START).build();
    }
}
