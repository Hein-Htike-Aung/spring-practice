package com.example.module13urlbasedsecurity.dao;

import com.example.module13urlbasedsecurity.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
