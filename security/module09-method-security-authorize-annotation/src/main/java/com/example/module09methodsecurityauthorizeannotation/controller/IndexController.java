package com.example.module09methodsecurityauthorizeannotation.controller;

import com.example.module09methodsecurityauthorizeannotation.entity.Users;
import com.example.module09methodsecurityauthorizeannotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class IndexController {

    @Autowired
    private UserService userService;

    // curl -u karina:12345 -H "Content-Type:application/json" localhost:8080/pre/authorize/karina | jq
    // curl -u xiaoting:12345 -H "Content-Type:application/json" localhost:8080/pre/authorize/xiaoting | jq
    @GetMapping("/pre/authorize/{name}")
    public Users preAuthorize(
            @PathVariable("name") String name
    ) {
        return this.userService.preAuthorize(name);
    }

    // curl -u xiaoting:12345 -H "Content-Type:application/json" localhost:8080/pre/authorize2/xiaoting | jq
    // curl -u karina:12345 -H "Content-Type:application/json" localhost:8080/pre/authorize2/karina | jq
    @GetMapping("/pre/authorize2/{name}")
    public Users preAuthorize2(
            @PathVariable("name") String name
    ) {
        return this.userService.preAuthorize02(name);
    }

    // curl -u xiaoting:12345 -H "Content-Type:application/json" localhost:8080/pre/filter | jq
    // curl -u karina:12345 -H "Content-Type:application/json" localhost:8080/pre/filter | jq
    @GetMapping("/pre/filter")
    public List<Users> preFilter(){
        List<Users> users = this.userService.findAll();
        return this.userService.preFilter(users);
    }

    // curl -u karina:12345 -H "Content-Type:application/json" localhost:8080/post/authorize/karina | jq
    // curl -u xiaoting:12345 -H "Content-Type:application/json" localhost:8080/post/authorize/xiaoting | jq
    @GetMapping("/post/authorize/{name}")
    public Users postAuthorize(
            @PathVariable("name") String name
    ) {
        return this.userService.postAuthorize(name);

    }

    // curl -u xiaoting:12345 -H "Content-Type:application/json" localhost:8080/post/filter | jq
    // curl -u karina:12345 -H "Content-Type:application/json" localhost:8080/post/filter | jq
    @GetMapping("/post/filter")
    public Iterable<Users> postFilter(){
        return this.userService.postFilter();
    }

    // curl -u karina:12345 -H "Content-Type:application/json" localhost:8080/post/filter/login/user | jq
    // curl -u xiaoting:12345 -H "Content-Type:application/json" localhost:8080/post/filter/login/user | jq
    @GetMapping("/post/filter/login/user")
    public Iterable<Users> postFilter2(){
        return this.userService.inQueryLoginUser();
    }


}
