package com.example.module07transaction.service;

import com.example.module07transaction.dao.EmployeeDao;
import com.example.module07transaction.entity.Employee;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public void saveEmployeesWithTransaction() {

        Employee employee1 = new Employee("Xiaoting", LocalDate.of(2014, 5, 11), 2000);
        Employee employee2 = new Employee("Karina", LocalDate.of(2018, 4, 11), 2000);
        Employee employee3 = new Employee(null, LocalDate.of(2015, 10, 11), 2000);

        employeeDao.save(employeeValidation(employee1));
        employeeDao.save(employeeValidation(employee2));
        employeeDao.save(employeeValidation(employee3));

    }

    public Employee employeeValidation(Employee employee) {

        if(employee.getName() == null) {
            throw new RuntimeException("Incorrect Data");
        }

        return employee;
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
