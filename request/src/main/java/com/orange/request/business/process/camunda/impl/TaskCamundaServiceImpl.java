package com.orange.request.business.process.camunda.impl;

import com.orange.request.business.process.camunda.services.TaskCamundaService;
import com.orange.request.representation.process.TaskRepresentation;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskCamundaServiceImpl implements TaskCamundaService {

    @Autowired
    TaskCamundaServiceImpl(TaskService taskService){
        this.taskService = taskService;
    }

    TaskService taskService;


    @Override
    public List<TaskRepresentation> userTaskList() {

        List<Task> taskList = taskService.createTaskQuery().taskDefinitionKey("Task_0dfv74n").list();
        List<TaskRepresentation> taskRepresentationList = new ArrayList<>();
        if(taskList!=null && !taskList.isEmpty()){
            taskList.stream().forEach(entre->{
                taskRepresentationList.add(TaskRepresentation.builder()
                        .taskId(entre.getId()).assignee(entre.getAssignee()).build());
            });
        }
        return taskRepresentationList;
    }
}
