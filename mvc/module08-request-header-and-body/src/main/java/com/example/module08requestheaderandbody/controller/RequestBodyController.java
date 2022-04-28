package com.example.module08requestheaderandbody.controller;

import com.example.module08requestheaderandbody.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RequestBodyController {

    // curl -X POST -d "{\"id\":\"1\",\"name\":\"xiaoting\"}" -H "Content-Type:application/json" http://localhost:8080/requestBody01
    @PostMapping("/requestBody01")
    @ResponseBody
    public String requestBody(
            @RequestBody String body
    ){

        return String.format("Value = [%s]", body);
    }

    // curl -X POST -d "{\"id\":\"1\",\"name\":\"xiaoting\"}" -H "Content-Type:application/json" http://localhost:8080/requestBody02
    @PostMapping("/requestBody02")
    @ResponseBody
    public String requestBody02(
            @RequestBody Person person
    ){

        return String.format("Value = [%s]", person);
    }

    // curl -X POST -H "Content-Type:application/json" http://localhost:8080/requestBody03
    @PostMapping("/requestBody03")
    @ResponseBody
    public String requestBody03(
            @RequestBody(required = false) Optional<Person> person
    ){

        return String.format("Value = [%s]", person);
    }

    // curl -X POST -d "{\"id\":\"1\",\"name\":\"\"}" -H "Content-Type:application/json" http://localhost:8080/requestBody04
    @PostMapping("/requestBody04")
    @ResponseBody
    public String requestBody04(
            @RequestBody @Valid Person person,
            BindingResult bindingResult
    ){

        if(bindingResult.hasErrors()){
            return String.format("BindingResultErrors = {%s}", bindingResult.getErrorCount());
        }
        return String.format("Value = [%s]", person);
    }


}
