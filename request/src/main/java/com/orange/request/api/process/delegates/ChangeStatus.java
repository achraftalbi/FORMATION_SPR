package com.orange.request.api.process.delegates;

import com.orange.request.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class ChangeStatus implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        //String businessKey = (String) delegateExecution.getVariable(Constants.BUSINESS_KEY);
        String status = (String) delegateExecution.getVariable(Constants.STATUS);
        log.info("My request number={}", status);

    }
}
