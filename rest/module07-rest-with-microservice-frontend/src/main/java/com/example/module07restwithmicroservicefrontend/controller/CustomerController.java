package com.example.module07restwithmicroservicefrontend.controller;

import com.example.module07restwithmicroservicefrontend.ds.Customer;
import com.example.module07restwithmicroservicefrontend.ds.Customers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CustomerController {

    @Value("${app.backend.url}")
    private String backendUrl;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/customers")
    public ModelAndView customers() {

        ResponseEntity<Customers> responseEntity = restTemplate
                .getForEntity(backendUrl + "/customers", Customers.class);

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException("Cannot retrieve customer data");
        } else {
            return new ModelAndView("/customers", "customers", responseEntity.getBody().getCustomerList());
        }
    }

    @GetMapping("/customers/create")
    public ModelAndView create() {
        return new ModelAndView("/customer", "customer", new Customer());
    }

    @PostMapping("/customers/create")
    public String create(
            @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "/customer";
        }

        ResponseEntity<Customer> responseEntity = restTemplate
                .postForEntity(backendUrl + "/customers/create", customer, Customer.class);

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException("Can not add customer");
        } else {
            return "redirect:/customers";
        }
    }

    @GetMapping("/customers/delete/{id}")
    public String delete(
            @PathVariable("id") int id
    ) {
        this.restTemplate.delete(backendUrl + "/customers/delete/{id}", id);
        return "redirect:/customers";

    }

}
