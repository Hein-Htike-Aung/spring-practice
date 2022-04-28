package com.example.module05buildinrest.repository;

import com.example.module05buildinrest.entity.Address;
import com.example.module05buildinrest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
