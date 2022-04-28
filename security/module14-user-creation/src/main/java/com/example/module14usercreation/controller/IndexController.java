package com.example.module14usercreation.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(
            Authentication authentication,
            Model model
    ) {

        System.out.println(authentication.getName());
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getAuthorities());

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getAuthorities());
        System.out.println(userDetails.isAccountNonExpired());
        System.out.println(userDetails.isAccountNonLocked());
        System.out.println(userDetails.isCredentialsNonExpired());
        System.out.println(userDetails.isEnabled());

        model.addAttribute("principle", authentication.getPrincipal());

        return "/index";
    }
}
