package com.example.module10methodsecurityjsrsecuredannotation.controller;

import com.example.module10methodsecurityjsrsecuredannotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    // curl -u karina:12345 localhost:8080/secured
    // curl -u xiaoting:12345 localhost:8080/secured
    @GetMapping("/secured")
    public String secured() {
        return this.userService.getUserUsingSecured();
    }

    // curl -u karina:12345 localhost:8080/roles/allowed
    // curl -u xiaoting:12345 localhost:8080/roles/allowed
    @GetMapping("/roles/allowed")
    public String rolesAllowed() {
        return this.userService.getUserUsingRolesAllowed();
    }
}
