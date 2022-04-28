package com.example.module04onetomany.com.hha.dao;

import com.example.module04onetomany.com.hha.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

    @Query("select c from Category c join fetch c.productList where c.name=?1")
    Category fetchName(String name);
}
