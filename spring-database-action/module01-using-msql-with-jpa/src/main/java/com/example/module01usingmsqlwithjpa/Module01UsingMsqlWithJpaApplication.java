package com.example.module01usingmsqlwithjpa;

import com.example.module01usingmsqlwithjpa.com.hha.entity.Employee;
import com.example.module01usingmsqlwithjpa.com.hha.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module01UsingMsqlWithJpaApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(Module01UsingMsqlWithJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee();
        employee.setName("Karina");

        employeeService.saveEmployee(employee);
        employeeService.printAllEmployee();
    }
}
