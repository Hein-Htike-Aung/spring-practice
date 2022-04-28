package com.example.module04onetomany.com.hha.dao;

import com.example.module04onetomany.com.hha.entity.Category;
import com.example.module04onetomany.com.hha.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
