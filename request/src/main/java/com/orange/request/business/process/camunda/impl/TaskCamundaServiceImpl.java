package com.orange.request.business.process.camunda.impl;

import com.orange.request.business.process.camunda.services.TaskCamundaService;
import com.orange.request.representation.process.TaskRepresentation;
import com.orange.request.representation.process.TreatTaskResponseRepresentation;
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

    void claimTask(String taskId, String userId){
        taskService.claim(taskId,userId);
    }

    void completeTask(String taskId){
        taskService.complete(taskId);
    }

    @Override
    public TreatTaskResponseRepresentation treatTask(String taskId, String userId){
        claimTask(taskId, userId);
        completeTask(taskId);
        return TreatTaskResponseRepresentation.builder()
                .taskId(taskId).taskCompleted(true).build();

    }

    @Override
    public List<TaskRepresentation> userTaskList() {

        List<Task> taskList = taskService.createTaskQuery().taskDefinitionKey("Activity_0cimfcu").list();
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
