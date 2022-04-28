package com.example.module12mvccrudmultipagesmultitables.dao;

import com.example.module12mvccrudmultipagesmultitables.entity.Category;
import com.example.module12mvccrudmultipagesmultitables.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where " +
            "concat(p.name, p.price) " +
            "like %?1%")
    List<Product> findByKeyword(String keyword);
}
