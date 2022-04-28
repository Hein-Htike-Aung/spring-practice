package com.example.module04jsonxml.controller;

import com.example.module04jsonxml.dao.CustomerDao;
import com.example.module04jsonxml.entity.Customer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.Bidi;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/response", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ResponseStatusExceptionController {

    @Autowired
    private CustomerDao customerDao;

    // curl -H "Content-Type:application/json" localhost:8080/response/customers |jq
    @GetMapping("/customers")
    public Iterable<Customer> findAll() {
        return this.customerDao.findAll();
    }

    // curl -H "Content-Type:application/json" localhost:8080/response/customers/1 |jq
    @GetMapping("/customers/{id}")
    public Customer findById(
            @PathVariable("id") int id
    ) {
        return this.customerDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // curl -X PUT -H "Content-Type:application/json" -d "{\"customerName\":\"Aung Aung\"}" localhost:8080/response/customers/save |jq
    @PutMapping(value = "/customers/save")
    public Customer save(
            @RequestBody @Valid Customer customer,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, getBindingResultError(bindingResult));
        }
        return this.customerDao.save(customer);
    }

    // curl -X PATCH -H "Content-Type:application/json" -d "{\"customerName\":\"\"}" localhost:8080/response/customers/update/3 |jq
    @PatchMapping("/customers/update/{id}")
    public Customer update(
            @PathVariable("id") int id,
            @RequestBody @Valid Customer customer,
            BindingResult bindingResult
    ) {
        if (!this.customerDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, getBindingResultError(bindingResult));
        }
        customer.setId(id);
        return this.customerDao.save(customer);
    }

    // curl -X DELETE -H "Content-Type:application/json" localhost:8080/response/customers/delete/6 |jq
    // curl -H "Content-Type:application/json" localhost:8080/response/customers |jq
    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity<?> delete(
            @PathVariable("id") int id
    ) {
        Customer c = this.customerDao.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (c.getCustomerName().equals("Xiaoting")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        this.customerDao.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public String getBindingResultError(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(ObjectError::getObjectName)
                .collect(Collectors.joining(", "));
    }
}
