package com.example.module2oauthgithubauthentication.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/login/github")
    public ModelAndView loginWithGithub(
            Authentication authentication
    ) {
        OAuth2User user = (OAuth2User) authentication.getPrincipal();

        return new ModelAndView("/home", "username", user.getAttribute("login"));
    }

}
