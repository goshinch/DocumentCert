package com.nhnacademy.documentcert.advice;

import com.nhnacademy.documentcert.exception.ErrorMessage;
import com.nhnacademy.documentcert.exception.ResidentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonRestControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {binder.initDirectFieldAccess();}

    @ExceptionHandler(ResidentNotFoundException.class)
    public ResponseEntity<ErrorMessage> residentNotFound(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
