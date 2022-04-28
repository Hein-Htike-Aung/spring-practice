package com.example.module02restcontrollerparameter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class RequestParamController {

    // curl -X GET "localhost:8080/requestParamMethod01?value=karina"
    @GetMapping("/requestParamMethod01")
    public String requestParamMethod01(
            @RequestParam("value") String value
    ) {
        return String.format("Value = [%s]", value);
    }

    // curl -X GET "localhost:8080/requestParamMethod02?value=karina"
    // curl -X GET "localhost:8080/requestParamMethod02?value=karina&value2=giselle"
    @GetMapping("/requestParamMethod02")
    public String requestParamMethod02(
            @RequestParam(name = "value") String value,
            @RequestParam(name = "value2", required = false, defaultValue = "N/A") String value02

    ) {
        return String.format("Value = [%s] [%s]", value, value02);
    }

    // curl -X GET "localhost:8080/requestParamMethod03?values=karina,giselle"
    @GetMapping("/requestParamMethod03")
    public String requestParamMethod03(
            @RequestParam("values") List<String> list
    ) {
        return list.stream()
                .map(l -> String.format("Values = [%s]", l))
                .collect(Collectors.joining(", "));
    }

    // curl -X GET "localhost:8080/requestParamMethod04?bias1=karina&bias2=giselle"
    @GetMapping("/requestParamMethod04")
    public String requestParamMethod04(
            @RequestParam Map<String, String> map
    ) {
        return map.entrySet().stream()
                .map(entry -> String.format("Key : [%s], Value : [%s]", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
    }

}
