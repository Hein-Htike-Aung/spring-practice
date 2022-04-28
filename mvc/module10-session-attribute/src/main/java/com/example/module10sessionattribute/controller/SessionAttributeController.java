package com.example.module10sessionattribute.controller;

import com.example.module10sessionattribute.entity.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@Controller
public class SessionAttributeController {

    // curl http://localhost:8080/session/counter-up
    @GetMapping("/session/counter-up")
    @ResponseBody
    public String sessionAttribute01(
            @SessionAttribute(name = "counter") Counter counter
    ) {
        counter.countUp();
        return String.format("Counter Value = [%s]", counter.getCount());
    }

    // curl http://localhost:8080/session/counter-up2
    @GetMapping("/session/counter-up2")
    @ResponseBody
    public String sessionAttribute02(
            @SessionAttribute(name = "counter", required = false) Optional<Counter> counter
    ) {
        counter.get().countUp();
        counter.get().countUp();
        return String.format("Counter Value = [%s]", counter.get().getCount());
    }

}
