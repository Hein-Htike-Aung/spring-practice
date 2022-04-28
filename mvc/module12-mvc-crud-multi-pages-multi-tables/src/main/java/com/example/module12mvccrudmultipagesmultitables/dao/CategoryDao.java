package com.example.module12mvccrudmultipagesmultitables.dao;

import com.example.module12mvccrudmultipagesmultitables.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

    @Query("select c from Category c where c.name like %?1%")
    List<Category> findByName(String name);
}
