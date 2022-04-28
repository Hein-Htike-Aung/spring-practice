package com.example.module11custmizhaspermission.controller;

import com.example.module11custmizhaspermission.Entity.Users;
import com.example.module11custmizhaspermission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    // curl -u karina:12345 localhost:8080/get/users/karina
    // curl -u karina:12345 localhost:8080/get/users/xiaoting
    // curl -u xiaoting:12345 localhost:8080/get/users/xiaoting
    // curl -u xiaoting:12345 localhost:8080/get/users/karina
    @GetMapping("/get/users/{name}")
    public Users getUsers1(
            @PathVariable("name") String name
    ) {
        return this.userService.getUsers(name);
    }

    // curl -u karina:12345 localhost:8080/get/users2/karina
    // curl -u karina:12345 localhost:8080/get/users2/xiaoting
    // curl -u xiaoting:12345 localhost:8080/get/users2/xiaoting
    // curl -u xiaoting:12345 localhost:8080/get/users2/karina
    @GetMapping("/get/users2/{name}")
    public Users getUsers2(
            @PathVariable("name") String name
    ) {
        return this.userService.getUsers2(name);
    }
}
