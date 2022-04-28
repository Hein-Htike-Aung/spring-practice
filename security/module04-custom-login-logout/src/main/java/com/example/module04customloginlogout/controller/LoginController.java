package com.example.module04customloginlogout.controller;


import com.example.module04customloginlogout.security.PasswordCredentialException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(
            HttpServletRequest request,
            Model model
    ) {

        Exception exception = (Exception) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");

        if (exception instanceof UsernameNotFoundException) {
            model.addAttribute("invalidUsername", exception.getMessage());
        } else if (exception instanceof PasswordCredentialException) {
            model.addAttribute("invalidPassword", exception.getMessage());
        } else if (exception instanceof BadCredentialsException){
            model.addAttribute("invalid", exception.getMessage());
        }

        return "login";
    }

}
