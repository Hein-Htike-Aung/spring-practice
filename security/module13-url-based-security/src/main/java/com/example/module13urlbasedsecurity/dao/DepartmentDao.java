package com.example.module13urlbasedsecurity.dao;

import com.example.module13urlbasedsecurity.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
