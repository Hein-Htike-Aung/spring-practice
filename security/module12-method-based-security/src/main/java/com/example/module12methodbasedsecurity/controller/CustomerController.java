package com.example.module12methodbasedsecurity.controller;

import com.example.module12methodbasedsecurity.dao.CustomerDao;
import com.example.module12methodbasedsecurity.entity.Customer;
import com.example.module12methodbasedsecurity.security.annotations.customer.CustomerCreate;
import com.example.module12methodbasedsecurity.security.annotations.customer.CustomerDelete;
import com.example.module12methodbasedsecurity.security.annotations.customer.CustomerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;

import static com.example.module12methodbasedsecurity.security.UserRoles.*;


@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping
    public ModelAndView customers() {
        return new ModelAndView("/backend/customers", "customers", this.customerDao.findAll());
    }

//    @Secured({PREFIX + CUSTOMER_CREATE, PREFIX + CUSTOMER_UPDATE})
    @CustomerCreate @CustomerUpdate
    @GetMapping({"/create", "/update"})
    public ModelAndView create() {
        return new ModelAndView("/backend/customer", "customer", new Customer());
    }

//    @Secured(PREFIX + CUSTOMER_CREATE)
    @CustomerCreate
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

//    @Secured(PREFIX + CUSTOMER_UPDATE)
    @CustomerUpdate
    @GetMapping("/update/{id}")
    public String update(
            @PathVariable("id") int cusId,
            Model model
    ) {
        model.addAttribute("customer", this.customerDao.findById(cusId));

        return "/backend/customer";
    }

//    @Secured(PREFIX + CUSTOMER_DELETE)
    @CustomerDelete
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id
    ) {
        this.customerDao.deleteById(id);
        return "redirect:/customers";
    }
}
