package com.example.module13urlbasedsecurity.controller;

import com.example.module13urlbasedsecurity.dao.CustomerDao;
import com.example.module13urlbasedsecurity.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;


@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping
    public ModelAndView customers() {
        return new ModelAndView("/backend/customers", "customers", this.customerDao.findAll());
    }

    @GetMapping("/details/{id}")
    public ModelAndView customerDetails(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("details", true);
        return new ModelAndView("/backend/customer", "customer", this.customerDao.findById(id));
    }

    @GetMapping({"/create", "/update"})
    public ModelAndView create(
            Model model
    ) {
        model.addAttribute("details", false);
        return new ModelAndView("/backend/customer", "customer", new Customer());
    }

    @PostMapping("/create")
    @Transactional
    public String create(
            @Valid Customer customer,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return "/backend/customer";
        }

        if (customer.getId() == 0) {
            this.customerDao.save(customer);
        } else {
            Customer c = this.customerDao.findById(customer.getId()).orElse(null);
            c.setCusName(customer.getCusName());
            this.customerDao.save(c);
        }
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public String update(
            @PathVariable("id") int cusId,
            Model model
    ) {
        model.addAttribute("details", false);
        model.addAttribute("customer", this.customerDao.findById(cusId));

        return "/backend/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id
    ) {
        this.customerDao.deleteById(id);
        return "redirect:/customers";
    }
}
