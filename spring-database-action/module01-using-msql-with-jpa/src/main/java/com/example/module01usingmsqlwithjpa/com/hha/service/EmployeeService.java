package com.example.module01usingmsqlwithjpa.com.hha.service;

import com.example.module01usingmsqlwithjpa.com.hha.entity.Employee;
import com.example.module01usingmsqlwithjpa.com.hha.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void printAllEmployee() {
        employeeRepository.findAll().forEach(System.out::println);
    }
}
