package com.example.customerservice.dao;

import com.example.customerservice.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao extends JpaRepository<Customer, Integer> {
}
