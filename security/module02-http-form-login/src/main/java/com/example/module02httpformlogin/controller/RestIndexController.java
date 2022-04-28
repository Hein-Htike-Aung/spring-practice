package com.example.module02httpformlogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestIndexController {

    // curl -u user:98e8fabd-5c35-478b-af69-1b31e2d38e53 localhost:8080/rest
    @GetMapping("/rest")
    public String index() {
        return "Hello, Xiaoting";
    }
}
