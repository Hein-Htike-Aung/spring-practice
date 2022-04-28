package com.example.module01usingmsqlwithjpa.com.hha.repository;

import com.example.module01usingmsqlwithjpa.com.hha.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
