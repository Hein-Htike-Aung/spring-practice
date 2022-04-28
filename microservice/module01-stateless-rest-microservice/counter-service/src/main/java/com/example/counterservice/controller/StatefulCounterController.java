package com.example.counterservice.controller;

import com.example.counterservice.ds.StatefulCounter;
import com.example.counterservice.service.ResponseBodyCounter;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class StatefulCounterController {

    @Autowired
    private StatefulCounter statefulCounter;

    // need cookie
    // curl -b cookies.txt -c cookies.txt -X GET -H "Content-Type:application/json" http://localhost:8080/counter/stateful/count/up |jq
    @GetMapping("/stateful/count/up")
    public ResponseBodyCounter countUp(){

        this.statefulCounter.countUp();

        return new ResponseBodyCounter(statefulCounter.getCounter());
    }
}
