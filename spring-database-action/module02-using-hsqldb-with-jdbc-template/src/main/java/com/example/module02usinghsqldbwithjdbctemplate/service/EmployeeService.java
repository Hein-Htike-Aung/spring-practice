package com.example.module02usinghsqldbwithjdbctemplate.service;

import com.example.module02usinghsqldbwithjdbctemplate.dao.EmployeeDao;
import com.example.module02usinghsqldbwithjdbctemplate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printAll() {

        System.out.println("\nFind By Id");
        System.out.println(employeeDao.findById(1));

        System.out.println("\nFind by Id (Using queryForMap)");
        System.out.println(employeeDao.findByIdMapStructure(3));

        System.out.println("\nEmployee Name By Id");
        System.out.println(employeeDao.findEmployeeNameById(4));

        System.out.println("\nEmployee List");
        employeeDao.findEmployeeList().forEach(System.out::println);

        System.out.println("\nEmployee Name List");
        employeeDao.findAllEmployeeNames().forEach(System.out::println);

        System.out.println("\nInsert New Employee");
        System.out.println(employeeDao.saveEmployee(new Employee(6, "John", new Date(System.currentTimeMillis()), 4555)));

        System.out.println("\nUpdate By Id");
        System.out.println(employeeDao.updateById(6));

        System.out.println("\nDelete by Id");
        System.out.println(employeeDao.deleteById(6));

        System.out.println("\nAverage Salary");
        System.out.println(employeeDao.findEmployeeAvgSalary());

        System.out.println("\nEmployee Count");
        System.out.println(employeeDao.findEmployeeCount());

        System.out.println("\nBatch Update");
        employeeDao.updateEmployees(getEmployees());

        System.out.println("\nEmployee List");
        employeeDao.findEmployeeList().forEach(System.out::println);

    }

    private List<Employee> getEmployees() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Mashiro");
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Aung");
        return List.of(employee, employee2);
    }
}
