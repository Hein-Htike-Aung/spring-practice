package com.example.module12methodbasedsecurity.controller;

import com.example.module12methodbasedsecurity.dao.CustomerDao;
import com.example.module12methodbasedsecurity.dao.DepartmentDao;
import com.example.module12methodbasedsecurity.entity.Department;
import com.example.module12methodbasedsecurity.security.annotations.department.DepartmentCreate;
import com.example.module12methodbasedsecurity.security.annotations.department.DepartmentDelete;
import com.example.module12methodbasedsecurity.security.annotations.department.DepartmentUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.validation.Valid;

import static com.example.module12methodbasedsecurity.security.UserRoles.*;


@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping
    public ModelAndView departments() {
        return new ModelAndView("/backend/departments", "departments", this.departmentDao.findAll());
    }

//    @RolesAllowed({PREFIX + DEPARTMENT_CREATE, PREFIX + DEPARTMENT_UPDATE})
    @DepartmentCreate @DepartmentUpdate
    @GetMapping({"/create", "/update"})
    public ModelAndView create() {
        return new ModelAndView("/backend/department", "department", new Department());
    }

//    @RolesAllowed(PREFIX + DEPARTMENT_CREATE)
    @DepartmentCreate
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

//    @RolesAllowed(PREFIX + DEPARTMENT_UPDATE)
    @DepartmentUpdate
    @GetMapping("/update/{id}")
    public String update(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("department", this.departmentDao.findById(id));
        return "/backend/department";
    }

//    @RolesAllowed(PREFIX + DEPARTMENT_DELETE)
    @DepartmentDelete
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id
    ) {
        this.departmentDao.deleteById(id);
        return "redirect:/departments";
    }
}
