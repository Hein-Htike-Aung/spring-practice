package com.example.module13urlbasedsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

    private Logger logger = LoggerFactory.getLogger(ErrorController.class.getName());

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(
            Throwable throwable,
            Model model
    ) {
        logger.error("Exception occurred during application execution -> [%s]", throwable);

        String errorMessage = (throwable != null) ? throwable.getMessage() : "Unknown Error";
        model.addAttribute("errorMessage", errorMessage);

        return "/commons/error";
    }
}
