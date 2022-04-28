package com.example.counterservice.controller;

import com.example.counterservice.service.RequestBodyCounter;
import com.example.counterservice.service.ResponseBodyCounter;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class StatelessCounterController {


    // curl -X GET -H "Content-Type:application/json" -d "{\"number\":\"4\"}" http://localhost:8080/counter/stateless/count/up |jq
    @GetMapping("/stateless/count/up")
    public ResponseBodyCounter countUp(
            @RequestBody RequestBodyCounter requestBodyCounter
    ){

        return new ResponseBodyCounter(requestBodyCounter.getNumber() + 1);
    }
}
