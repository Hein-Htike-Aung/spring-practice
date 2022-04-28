package com.example.module04oauthfbauthentication.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2LoginAuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {

        return "/index";
    }

    @GetMapping("/login/fb")
    public ModelAndView index(
            Authentication authentication
    ) {

        OAuth2User user = (OAuth2User)authentication.getPrincipal();

        return new ModelAndView("/home", "user", user.getAttribute("name"));

    }
}
