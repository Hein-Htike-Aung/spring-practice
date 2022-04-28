package com.example.module01springform.service;

import com.example.module01springform.dao.EmployeeDao;
import com.example.module01springform.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public void save(Employee employee) {
        employeeDao.save(employee);
    }
}
