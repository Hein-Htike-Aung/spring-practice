package com.example.module03mvccrudonepageonetable.dao;

import com.example.module03mvccrudonepageonetable.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
