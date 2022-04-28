package com.example.module07restwithmicroservicebackend.dao;

import com.example.module07restwithmicroservicebackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
