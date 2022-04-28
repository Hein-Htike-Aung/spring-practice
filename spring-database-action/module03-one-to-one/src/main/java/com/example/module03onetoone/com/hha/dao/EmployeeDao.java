package com.example.module03onetoone.com.hha.dao;

import com.example.module03onetoone.com.hha.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
