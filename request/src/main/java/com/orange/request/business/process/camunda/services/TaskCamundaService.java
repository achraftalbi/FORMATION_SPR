package com.orange.request.business.process.camunda.services;

import com.orange.request.exceptions.request.RequestNotFoundException;
import com.orange.request.representation.process.TaskRepresentation;
import com.orange.request.representation.request.RequestRepresentation;

import java.util.List;

public interface TaskCamundaService {
    List<TaskRepresentation> userTaskList();
}
