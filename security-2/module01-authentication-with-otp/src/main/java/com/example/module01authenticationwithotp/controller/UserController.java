package com.example.module01authenticationwithotp.controller;

import com.example.module01authenticationwithotp.entity.Otp;
import com.example.module01authenticationwithotp.entity.User;
import com.example.module01authenticationwithotp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // curl -X POST -H "Content-Type:application/json" -d "{\"username\":\"karina\",\"password\":\"12345\"}" localhost:8080/users/add |jq
    @PostMapping("/users/add")
    public User add(
            @RequestBody User user
    ) {
        return this.userService.add(user);
    }

    // curl -X POST -H "Content-Type:application/json" -d "{\"username\":\"karina\",\"password\":\"12345\"}" localhost:8080/users/auth |jq
    @PostMapping("/users/auth")
    public Otp auth(
            @RequestBody User user
    ) {
        return this.userService.auth(user);
    }

    // curl -v -X POST -H "Content-Type:application/json" -d "{\"username\":\"karina\",\"otp\":\"1146\"}" localhost:8080/users/check/otp
    @PostMapping("/users/check/otp")
    public void checkOtp(
            @RequestBody Otp otp,
            HttpServletResponse responseStatus
    ) {
        boolean checkedOtp = this.userService.checkOtp(otp);

        if (checkedOtp) {
            responseStatus.setStatus(HttpServletResponse.SC_OK);
        } else {
            responseStatus.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
