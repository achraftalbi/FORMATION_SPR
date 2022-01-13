package com.orange.request.advice.global;

import com.orange.request.exceptions.generic.NotFoundException;
import com.orange.request.exceptions.messages.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalAdviceExceptionHandler {

    @ExceptionHandler(value= NotFoundException.class)
    ResponseEntity<ErrorMessage> resourceNotFoundException(NotFoundException ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code(HttpStatus.NOT_FOUND.value()).message(ex.getMessage())
                .date(new Date()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
