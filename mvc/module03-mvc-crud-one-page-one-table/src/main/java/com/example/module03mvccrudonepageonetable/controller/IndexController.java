package com.example.module03mvccrudonepageonetable.controller;

import com.example.module03mvccrudonepageonetable.entity.Employee;
import com.example.module03mvccrudonepageonetable.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller
public class IndexController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {

        model.addAttribute("employees", this.employeeService.findAll());
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("employees", this.employeeService.findAll());
            return "/index";
        }
        this.employeeService.saveEmployee(employee);
        return "redirect:/index";
    }

    @PostMapping("/update-employee")
    public String updateEmployee(@PathParam("id") int id, Model model) {

        model.addAttribute("employee", this.employeeService.findById(id));
        model.addAttribute("employees", this.employeeService.findAll());

        return "/index";
    }

    @PostMapping("/delete-employee")
    public String deleteEmployee(@PathParam("id") int id) {
        this.employeeService.deleteById(id);

        return "redirect:/index";
    }

}
