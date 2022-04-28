package com.example.module03userdetailsserviceauthquery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // curl -u xiaoting:12345 localhost:8080/index
    @GetMapping("/index")
    public String index(){
        return "Hello!!!";
    }
}
