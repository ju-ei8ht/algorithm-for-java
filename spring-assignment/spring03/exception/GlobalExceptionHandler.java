package com.talk.talk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleException(Exception e){
        String msg = e.getMessage();
        return new ResponseEntity<String>(
                msg, HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}