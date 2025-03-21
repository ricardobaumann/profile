package com.github.ricbau.profile.controllers;

import com.github.ricbau.profile.output.RestError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public RestError handleConflict(DataIntegrityViolationException dataIntegrityViolationException) {
        return new RestError(dataIntegrityViolationException.getLocalizedMessage());
    }

}
