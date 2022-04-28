package com.example.module04jsonxml.controller;

import com.example.module04jsonxml.dao.CustomerDao;
import com.example.module04jsonxml.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class JsonController {

    @Autowired
    private CustomerDao customerDao;

    // curl -H "Content-Type:application/json" localhost:8080/customers |jq
    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> customers() {
        return this.customerDao.findAll();
    }

    // curl -H "Content-Type:application/json" localhost:8080/customers/10 |jq
    @GetMapping(value = "customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer findById(
            @PathVariable("id") int id
    ) {
        return this.customerDao.findById(id)
                .orElseThrow(() -> new HttpStatusException("Not Found"));

    }

    // curl -X PUT -H "Content-Type:application/json" -d "{\"customerName\":\"\"}" localhost:8080/customers/save |jq
    // curl localhost:8080/customers |jq
    @PutMapping(value = "/customers/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer save(
            @RequestBody @Valid Customer customer,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors())   {
            throw new HttpStatusException("Cannot save customer");
        }
        return this.customerDao.save(customer);
    }

    // curl -X PATCH -H "Content-Type:application/json" -d "{\"customerName\":\"Hein Htike\"}" localhost:8080/customers/10 |jq
    // curl -X PATCH -H "Content-Type:application/json" -d "{\"customerName\":\"\"}" localhost:8080/customers/1 |jq
    // curl localhost:8080/customers |jq
    @PatchMapping("/customers/{id}")
    public Customer update(
            @PathVariable("id") int id,
            @RequestBody @Valid Customer customer,
            BindingResult bindingResult
    ) {
        if (!this.customerDao.existsById(id) || bindingResult.hasErrors()) {
            throw new HttpStatusException(String.format("Cannot update Customer by Id", id));
        }

        customer.setId(id);
        return this.customerDao.save(customer);

    }

    // curl -X DELETE -H "Content-Type:application/json" localhost:8080/customers/delete/6
    // curl localhost:8080/customers |jq
    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity delete(
            @PathVariable("id") int id
    ) {
        this.customerDao.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
