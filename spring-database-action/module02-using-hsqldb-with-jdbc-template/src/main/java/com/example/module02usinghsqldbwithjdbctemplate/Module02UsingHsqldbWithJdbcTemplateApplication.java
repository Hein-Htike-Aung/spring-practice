package com.example.module02usinghsqldbwithjdbctemplate;

import com.example.module02usinghsqldbwithjdbctemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module02UsingHsqldbWithJdbcTemplateApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(Module02UsingHsqldbWithJdbcTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        employeeService.printAll();
    }
}
