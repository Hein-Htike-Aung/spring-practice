package com.example.module07urlauthorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPostController {

    // curl localhost:8080/get
    @GetMapping("/get")
    public String getMethod() {
        return "GET";
    }

    // curl -X POST -u karina:12345 localhost:8080/post
    // curl -X POST -u xiaoting:12345 localhost:8080/post
    @PostMapping("/post")
    public String postMethod() {
        return "POST";
    }

    // curl -u karina:12345 localhost:8080/doubleUrl/get
    // curl -u xiaoting:12345 localhost:8080/doubleUrl/get
    @GetMapping("/doubleUrl/get")
    public String getDoubleURL() {
        return "GET DOUBLE URL";
    }
}
