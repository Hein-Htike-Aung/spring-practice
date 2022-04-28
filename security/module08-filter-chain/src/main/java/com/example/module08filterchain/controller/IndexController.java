package com.example.module08filterchain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // curl -H "Authorization-Key:5BAA61E4C9B93F3F0682250B6CF8331B7EE68FD8" localhost:8080/index
    @GetMapping("/index")
    public String index() {
        return "Hello!!";
    }
}
