package com.example.module03onetoone.com.hha.dao;

import com.example.module03onetoone.com.hha.entity.BiographicalInfo;
import com.example.module03onetoone.com.hha.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiographicalInfoDao extends JpaRepository<BiographicalInfo, Integer> {
    
}
