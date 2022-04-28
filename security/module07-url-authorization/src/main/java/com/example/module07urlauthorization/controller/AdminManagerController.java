package com.example.module07urlauthorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminManagerController {

    // curl -u karina:12345 localhost:8080/admin
    // curl -u xiaoting:12345 localhost:8080/admin
    @GetMapping("/admin")
    public String admin() {
        return "ADMIN";
    }

    // curl -u karina:12345 localhost:8080/manager
    // curl -u xiaoting:12345 localhost:8080/manager
    @GetMapping("/manager")
    public String manager() {
        return "MANAGER";
    }
}
