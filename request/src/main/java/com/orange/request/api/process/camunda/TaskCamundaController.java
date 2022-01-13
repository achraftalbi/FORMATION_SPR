package com.orange.request.api.process.camunda;

import com.orange.request.business.process.camunda.services.TaskCamundaService;
import com.orange.request.representation.process.TaskRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/process")
public class TaskCamundaController {

    @Autowired
    TaskCamundaController(TaskCamundaService taskCamundaService){
        this.taskCamundaService = taskCamundaService;
    }

    TaskCamundaService taskCamundaService;

    @GetMapping(value = "userTaskList")
    List<TaskRepresentation> userTaskList(){
        return taskCamundaService.userTaskList();
    }

}
