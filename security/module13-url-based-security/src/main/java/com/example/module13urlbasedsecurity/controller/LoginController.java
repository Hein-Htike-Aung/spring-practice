package com.example.module13urlbasedsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "/commons/login";
    }

    @GetMapping("/login/error")
    public String logout(Model model) {
        model.addAttribute("loginError", true); // For Message
        return "/commons/login";
    }
}
