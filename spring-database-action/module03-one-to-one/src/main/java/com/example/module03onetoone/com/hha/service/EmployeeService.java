package com.example.module03onetoone.com.hha.service;

import com.example.module03onetoone.com.hha.dao.BiographicalInfoDao;
import com.example.module03onetoone.com.hha.dao.EmployeeDao;
import com.example.module03onetoone.com.hha.entity.BiographicalInfo;
import com.example.module03onetoone.com.hha.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private BiographicalInfoDao biographicalInfoDao;

    @Transactional
    public void saveEmployee() {

        Employee employee = new Employee();
        employee.setName("Xiao ting");
        employee.setPhone("010-3466-4356");

        Employee employee2 = new Employee();
        employee2.setName("Karina");
        employee2.setPhone("010-9999-4545");

        BiographicalInfo biographicalInfo = new BiographicalInfo();
        biographicalInfo.setDateOfBirth(LocalDate.of(1998,5,11));
        biographicalInfo.setMaritalStatus(false);

        BiographicalInfo biographicalInfo2 = new BiographicalInfo();
        biographicalInfo2.setDateOfBirth(LocalDate.of(2000,5,11));
        biographicalInfo2.setMaritalStatus(false);

        employee.setBiographicalInfo(biographicalInfo);
        employee2.setBiographicalInfo(biographicalInfo2);

        employeeDao.save(employee);
        employeeDao.save(employee2);

    }

    public Employee findById(int id) {
        return employeeDao.findById(id).orElse(null);
    }

    public List<Employee> findAllEmployee() {

        return employeeDao.findAll();
    }

    public void deleteEmployee(int id) {
        employeeDao.deleteById(id);
    }

}
