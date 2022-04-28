package com.example.module01jwtauthentication.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // curl -H "username:karina" -H "password:12345" localhost:9090/login
    // curl -v -H "username:karina" -H "otp:8826" localhost:9090/login

    // login with jwt token
    // curl -H "Authorization:eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6InhpYW90aW5nIn0.JkgiA-DROKQddULBb7imf9Yl7eU5tw2KzeVbrZ1cmKyJkjxJhcL6ZB418XDm9NmZRAImJQmqSzHMmutxJl5mfg" localhost:9090/test
    @GetMapping("/test")
    public String test(
            Authentication authentication
    ){
        return authentication.getName();
    }
}
