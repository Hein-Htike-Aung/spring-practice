package com.example.module12methodbasedsecurity.dao;

import com.example.module12methodbasedsecurity.entity.Customer;
import com.example.module12methodbasedsecurity.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
