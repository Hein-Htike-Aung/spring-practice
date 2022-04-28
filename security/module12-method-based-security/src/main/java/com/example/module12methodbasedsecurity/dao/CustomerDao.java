package com.example.module12methodbasedsecurity.dao;

import com.example.module12methodbasedsecurity.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
