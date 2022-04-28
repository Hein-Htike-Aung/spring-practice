package com.example.module04jsonxml.controller;

import com.example.module04jsonxml.dao.CustomerDao;
import com.example.module04jsonxml.entity.Customer;
import com.example.module04jsonxml.entity.Customers;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/xml")
public class XmlController {

    @Autowired
    private CustomerDao customerDao;

    // curl -H "Content-Type:application/xml" localhost:8080/xml/customers
    @GetMapping(path = "/customers", produces = MediaType.APPLICATION_XML_VALUE)
    public Customers customers() {
        return new Customers(this.customerDao.findAll());
    }

    // curl -H "Content-Type:application/xml" localhost:8080/xml/customers/1
    @GetMapping(path = "/customers/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Customer findById(
            @PathVariable("id") int id
    ) {
        Customer c = this.customerDao.findById(id).orElse(null);
        if (c == null) {
            throw new HttpStatusException(String.format("Can't find Customer By", id));
        }
        return c;
    }

    // curl -X PUT -H "Content-Type:application/xml" -d "<customer><customerName>Aung Aung</customerName></customer>" localhost:8080/xml/customers/save
    // curl -X PUT -H "Content-Type:application/xml" -d "<customer><customerName></customerName></customer>" localhost:8080/xml/customers/save
    // curl -H "Content-Type:application/xml" localhost:8080/xml/customers
    @PutMapping(path = "/customers/save", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public Customer save(
            @RequestBody @Valid Customer customer,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new HttpStatusException("Cannot Save");
        }
        return this.customerDao.save(customer);
    }

    // curl -X PATCH -H "Content-Type:application/xml" -d "<customer><customerName>Hein Htike</customerName></customer>" localhost:8080/xml/customers/update/6
    // curl -H "Content-Type:application/xml" localhost:8080/xml/customers
    @PatchMapping(path = "/customers/update/{id}", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public Customer update(
            @PathVariable("id") int id,
            @RequestBody @Valid Customer customer,
            BindingResult bindingResult
    ) {
        if (!this.customerDao.existsById(id) || bindingResult.hasErrors()) {
            throw new HttpStatusException(String.format("Cannot Update Customer Id %s", id));
        }
        customer.setId(id);
        return this.customerDao.save(customer);
    }

    // curl -X DELETE -H "Content-Type:application/xml" localhost:8080/xml/customers/delete/6
    // curl -H "Content-Type:application/xml" localhost:8080/xml/customers
    @DeleteMapping(path = "/customers/delete/{id}", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> delete(
            @PathVariable("id") int id
    ) {
        Customer c = this.customerDao.findById(id).orElse(null);
        if (c == null || c.getCustomerName().equals("Xiaoting")) {
            throw new HttpStatusException("Cannot delete Xiaoting");
        }
        this.customerDao.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
