package com.example.module04customloginlogout.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/index", "/"})
    private String index(){
        return "/index";
    }
}
