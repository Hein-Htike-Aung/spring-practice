package com.example.module04jsonxml.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(value=HttpStatus.I_AM_A_TEAPOT)
public class HttpStatusException extends RuntimeException {


    public HttpStatusException(String message) {
        super(message);
    }

}