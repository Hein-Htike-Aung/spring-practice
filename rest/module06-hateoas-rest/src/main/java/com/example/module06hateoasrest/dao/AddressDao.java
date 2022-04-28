package com.example.module06hateoasrest.dao;

import com.example.module06hateoasrest.entity.Address;
import com.example.module06hateoasrest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
}
