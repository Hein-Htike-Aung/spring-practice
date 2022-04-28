package com.example.addressservice.dao;

import com.example.addressservice.ds.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesDao extends JpaRepository<Address, Integer> {
}
