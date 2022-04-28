package com.example.module12methodbasedsecurity.controller;

import com.example.module12methodbasedsecurity.dao.CustomerDao;
import com.example.module12methodbasedsecurity.dao.EmployeeDao;
import com.example.module12methodbasedsecurity.entity.Employee;
import com.example.module12methodbasedsecurity.security.annotations.employee.EmployeeCreate;
import com.example.module12methodbasedsecurity.security.annotations.employee.EmployeeUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

import static com.example.module12methodbasedsecurity.security.UserRoles.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping
    public ModelAndView employees() {
        return new ModelAndView("/backend/employees", "employees", this.employeeDao.findAll());
    }

//    @PreAuthorize("hasAnyRole('ROLE_EMPLOYEE_CREATE', 'ROLE_EMPLOYE_UPDATE')")
    @EmployeeCreate @EmployeeUpdate
    @GetMapping({"/create", "/update"})
    public ModelAndView create() {
        return new ModelAndView("/backend/employee", "employee", new Employee());
    }

    @PostMapping("/create")
    @PreAuthorize("'Test'.equals(#employee.getEmpName()) && hasRole('ROLE_EMPLOYEE_CREATE')")
    @Transactional
    public String create(
            @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "/backend/employee";
        }

        if (employee.getId() == 0) {
            this.employeeDao.save(employee);
        } else {
            Employee e = this.employeeDao.findById(employee.getId()).orElse(null);
            e.setEmpName(employee.getEmpName());
            this.employeeDao.save(e);
        }
        return "redirect:/employees";
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYEE_UPDATE')")
    @GetMapping("/update/{id}")
    public String update(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("employee", this.employeeDao.findById(id));

        return "/backend/employee";
    }

    @PreAuthorize("#id <= 2 && hasRole('ROLE_EMPLOYEE_DELETE')")
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id
    ) {

        this.employeeDao.deleteById(id);
        return "redirect:/employees";
    }
}
