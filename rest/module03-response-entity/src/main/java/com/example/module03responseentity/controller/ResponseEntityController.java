package com.example.module03responseentity.controller;

import com.example.module03responseentity.dao.EmployeeDao;
import com.example.module03responseentity.entity.Employee;
import org.hibernate.internal.IteratorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResponseEntityController {

    @Autowired
    private EmployeeDao employeeDao;

    // curl localhost:8080/employees/creation
    @GetMapping("/creation")
    @Transactional
    public String creation() {

        Employee e1 = new Employee("Xiaoting");
        Employee e2 = new Employee("Karina");
        Employee e3 = new Employee("Giselle");

        this.employeeDao.save(e1);
        this.employeeDao.save(e2);
        this.employeeDao.save(e3);

        return "Successfully created";
    }

    // curl localhost:8080/employees/1 |jq
    @GetMapping("{id}")
    public ResponseEntity<Employee> findById(
            @PathVariable("id") int id
    ) {
        return this.employeeDao.findById(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    // curl localhost:8080/employees |jq
    @GetMapping("")
    public ResponseEntity<Iterable<Employee>> list() {
        return ResponseEntity.ok()
                .body(this.employeeDao.findAll());
    }

    // curl -I localhost:8080/employees/count
    @RequestMapping(path = "/count", method = RequestMethod.HEAD)
    public ResponseEntity<Iterable<Employee>> getCount() {
        return ResponseEntity.ok()
                .header("employee-count", String.valueOf(this.employeeDao.count()))
                .body(this.employeeDao.findAll());
    }

    // curl -X PUT -H "Content-Type:application/json" -d "{\"name\":\"Aung Aung\"}" localhost:8080/employees/save | jq
    @PutMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addEmployee(
            @RequestBody Employee employee
    ) {
        this.employeeDao.save(employee);
        return ResponseEntity.ok().build();
    }

    // curl -X PATCH -H "Content-Type:application/json" -d "{\"name\":\"NingNing\"}" localhost:8080/employees/update/4
    // curl localhost:8080/employees |jq
    @PatchMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateEmployee(
            @PathVariable("id") int id,
            @RequestBody Employee employee
    ) {
        if (this.employeeDao.existsById(id)) {
            employee.setId(id);
            this.employeeDao.save(employee);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // curl -X DELETE -H "Content-Type:application/json" localhost:8080/employees/delete/4
    // curl localhost:8080/employees |jq
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(
            @PathVariable("id") int id
    ) {
        if (this.employeeDao.existsById(id)) {
            this.employeeDao.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
