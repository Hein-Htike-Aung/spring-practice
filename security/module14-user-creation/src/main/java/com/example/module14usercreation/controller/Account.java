package com.example.module14usercreation.controller;

import com.example.module14usercreation.entity.UserDTO;
import com.example.module14usercreation.entity.Users;
import com.example.module14usercreation.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class Account {

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserProfileService userProfileService;


    @GetMapping("/user/register")
    public ModelAndView register() {
        return new ModelAndView("register", "user", new UserDTO());
    }

    @PostMapping("/user/register")
    public String register(
            @ModelAttribute("user") @Valid UserDTO users,
            BindingResult bindingResult
    ) {

        Users user = this.userProfileService.findUsersByUsername(users.getUsername());

        if(user != null) {
            bindingResult.rejectValue("username", null, "Username Already Existed!");
        }

        if (!users.getPassword().equals(users.getRepeatedPassword())) {
            bindingResult.rejectValue("password", null, "password doesn't match!!");
        }

        if (bindingResult.hasErrors()) {
            return "/register";
        }

        this.jdbcUserDetailsManager.createUser(
                new User(
                        users.getUsername(),
                        passwordEncoder.encode(users.getPassword()),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
                )
        );

        return "redirect:/login";
    }

    @GetMapping("/user/change")
    public ModelAndView changePassword() {

        return new ModelAndView("change-profile", "passwordChanger", new UserDTO());

    }

    @PostMapping("/user/change")
    public String changePassword(
            @ModelAttribute("passwordChanger") UserDTO passwordChanger,
            BindingResult bindingResult
    ) {

        if (!this.userProfileService.isPasswordChangeable(passwordChanger)) {
            bindingResult.rejectValue("oldPassword", null, "Password is incorrect");
        }
        if (passwordChanger.getPassword().equals(passwordChanger.getOldPassword())) {
            bindingResult.rejectValue("password", null, "Old and New Passwords are the same");
        }
        if (!passwordChanger.getPassword().equals(passwordChanger.getRepeatedPassword())) {
            bindingResult.rejectValue("password", null, "New Passwords and Repeated Password do not match");
        }
        if (bindingResult.hasErrors()) {
            return "/change-profile";
        }

        this.userProfileService.changePassword(passwordChanger);
        SecurityContextHolder.clearContext();

        return "redirect:/login";
    }


}
