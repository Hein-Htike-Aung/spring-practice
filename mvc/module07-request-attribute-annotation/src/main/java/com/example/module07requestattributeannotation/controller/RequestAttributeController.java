package com.example.module07requestattributeannotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class RequestAttributeController {


    // curl http://localhost:8080/request-attribute01
    @GetMapping("/request-attribute01")
    @ResponseBody
    public String testRequestAttribute(
            @RequestAttribute("localTime") String time
    ){
        return String.format("Time -> [%s]", time);
    }

    // curl http://localhost:8080/request-attribute02
    @GetMapping("/request-attribute02")
    @ResponseBody
    public String testRequestAttribute02(
            @RequestAttribute(value = "localTime") LocalDateTime time
    ){
        return String.format("Time -> [%s]", time);
    }

    // curl http://localhost:8080/request-attribute03
    @GetMapping("/request-attribute03")
    @ResponseBody
    public String testRequestAttribute03(
            @RequestAttribute(value = "localtime-non-existing", required = false) Optional<LocalDateTime> time
    ){
        return String.format("Time -> [%s]", time.orElse(LocalDateTime.of(1994,3,3, 21, 3)));
    }


}
