package com.example.module06custmizinmemoryuserdetailsmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // curl -u karina:12345 localhost:8080/index
    // curl -u xiaoting:12345 localhost:8080/index
    @GetMapping("/index")
    public String index() {
        return "Hello!!";
    }
}
