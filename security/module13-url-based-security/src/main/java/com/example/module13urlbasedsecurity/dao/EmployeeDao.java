package com.example.module13urlbasedsecurity.dao;

import com.example.module13urlbasedsecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
