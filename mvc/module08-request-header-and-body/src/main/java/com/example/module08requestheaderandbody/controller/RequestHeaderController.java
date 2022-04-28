package com.example.module08requestheaderandbody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RequestHeaderController {

    // curl -H "header:Xiao+ting" http://localhost:8080/requestHeader
    @GetMapping("/requestHeader")
    @ResponseBody
    public String requestHeader(
            @RequestHeader("header") String value
    ) {
        return String.format("Value = [%s]", value);
    }

    // curl -H "header:Xiao+ting" http://localhost:8080/requestHeader02
    @GetMapping("/requestHeader02")
    @ResponseBody
    public String requestHeaderMap(
            @RequestHeader("header") Map<String, String> value
    ) {
        return "value = " + value;
    }
}
