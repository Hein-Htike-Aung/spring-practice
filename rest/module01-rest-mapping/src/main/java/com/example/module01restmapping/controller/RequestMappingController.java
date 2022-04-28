package com.example.module01restmapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class RequestMappingController {

    // curl -X GET localhost:8080/method01
    // curl -X POST localhost:8080/method01
    @RequestMapping(path = "/method01", method = {RequestMethod.GET, RequestMethod.POST})
    public String method01() {
        return "RequestMethod.GET, RequestMethod.POST";
    }

    // curl -X GET localhost:8080/method02
    // curl -X POST localhost:8080/method02
    // curl -X PATCH localhost:8080/method02
    @RequestMapping(path = "/method02")
    public String method02() {
        return "RequestMethod.ALL";
    }
}
