package com.example.module07restwithmicroservicebackend.controller;

import com.example.module07restwithmicroservicebackend.dao.CustomerDao;
import com.example.module07restwithmicroservicebackend.entity.Customer;
import com.example.module07restwithmicroservicebackend.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomersController {

    @Autowired
    private CustomerDao customerDao;

    // curl -X GET -H "Content-Type:application/json" localhost:8081/customers |jq
    @GetMapping("/customers")
    public Customers listCustomer() {

        return new Customers(customerDao.findAll().spliterator());
    }

    // curl -X POST -H "Content-Type:application/json" -d "{\"customerName\":\"NingNing\"}" localhost:8081/customers/create
    @PostMapping("/customers/create")
    public Customer createCustomer(
            @RequestBody Customer customer
    ) {
        return customerDao.save(customer);
    }

    // curl -X DELETE -H "Content-Type:application/json" "" localhost:8081/customers/delete/1
    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity createCustomer(
            @PathVariable int id
    ) {

        if (customerDao.existsById(id)) {
            customerDao.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
