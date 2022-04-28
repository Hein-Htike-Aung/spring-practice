package com.example.module13urlbasedsecurity.controller;

import com.example.module13urlbasedsecurity.dao.DepartmentDao;
import com.example.module13urlbasedsecurity.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;



@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping
    public ModelAndView departments() {
        return new ModelAndView("/backend/departments", "departments", this.departmentDao.findAll());
    }

    @GetMapping("/details/{id}")
    public ModelAndView departmentDetails(
            @PathVariable("id") int id,
            Model model
    ){
        model.addAttribute("details", true);
        return new ModelAndView("/backend/department", "department", this.departmentDao.findById(id));
    }

    @GetMapping({"/create", "/update"})
    public ModelAndView create(
            Model model
    ) {
        model.addAttribute("details", false);
        return new ModelAndView("/backend/department", "department", new Department());
    }

    @PostMapping("/create")
    @Transactional
    public String create(
            @ModelAttribute @Valid Department department,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "/backend/department";
        }

        if(department.getId() == 0) {
            this.departmentDao.save(department);
        }else {
            Department d = this.departmentDao.findById(department.getId()).orElse(null);
            d.setDepName(department.getDepName());
            this.departmentDao.save(d);
        }
        return "redirect:/departments";
    }

    @GetMapping("/update/{id}")
    public String update(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("details", false);
        model.addAttribute("department", this.departmentDao.findById(id));
        return "/backend/department";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id
    ) {
        this.departmentDao.deleteById(id);
        return "redirect:/departments";
    }
}
