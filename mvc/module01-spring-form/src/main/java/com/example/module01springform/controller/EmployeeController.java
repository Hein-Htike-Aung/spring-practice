package com.example.module01springform.controller;

import com.example.module01springform.entity.Employee;
import com.example.module01springform.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("employees", this.employeeService.findAll());
        model.addAttribute("employee", new Employee());

        return "index";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("employees", this.employeeService.findAll());
            return  "/index";
        }
        this.employeeService.save(employee);
        return "redirect:/";
    }
}
