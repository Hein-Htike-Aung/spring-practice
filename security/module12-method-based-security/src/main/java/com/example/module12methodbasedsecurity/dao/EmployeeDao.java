package com.example.module12methodbasedsecurity.dao;

import com.example.module12methodbasedsecurity.entity.Customer;
import com.example.module12methodbasedsecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
