package com.example.module05buildinrest.repository;

import com.example.module05buildinrest.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
}
