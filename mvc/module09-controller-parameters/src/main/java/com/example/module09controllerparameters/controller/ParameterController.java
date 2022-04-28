package com.example.module09controllerparameters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
public class ParameterController {

    // curl "http://localhost:8080/path-param?firstName=Xiao&lastName=ting"
    @GetMapping("/path-param")
    @ResponseBody
    public String method01(
            @PathParam("firstName") String firstName,
            @PathParam("lastName") String lastName
    ){

        return String.format("FirstName = [%s], lastName = [%s]", firstName, lastName);
    }

    // curl http://localhost:8080/path-variable/Min/jeong
    @GetMapping("/path-variable/{firstName}/{lastName}")
    @ResponseBody
    public String method02(
            // use on RESTful web services
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName
    ){

        return String.format("FirstName = [%s], lastName = [%s]", firstName, lastName);
    }

    // curl "http://localhost:8080/request-param?firstName=Aung&lastName=Aung"
    @GetMapping("/request-param")
    @ResponseBody
    public String method03(
            // use on a traditional web application
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ){

        return String.format("FirstName = [%s], lastName = [%s]", firstName, lastName);
    }

}
