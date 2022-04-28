package com.example.module13urlbasedsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {

    @GetMapping("/user/profile")
    public String userProfile() {
        return "/backend/user-profile";
    }
}
