package com.example.module03mvccrudonepageonetable.service;

import com.example.module03mvccrudonepageonetable.dao.EmployeeDao;
import com.example.module03mvccrudonepageonetable.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findAll() {
        return this.employeeDao.findAll();
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        if(employee.getId() == 0) {
            this.employeeDao.save(employee);
        }else {
            Employee e = findById(employee.getId());
            e.setName(employee.getName());
            this.employeeDao.save(e);
        }
    }

    public Employee findById(int id) {
        return this.employeeDao.getById(id);
    }

    public void deleteById(int id) {
        this.employeeDao.deleteById(id);
    }
}
