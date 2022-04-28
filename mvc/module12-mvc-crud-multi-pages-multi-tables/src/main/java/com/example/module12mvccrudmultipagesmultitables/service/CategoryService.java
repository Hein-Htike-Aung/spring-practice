package com.example.module12mvccrudmultipagesmultitables.service;

import com.example.module12mvccrudmultipagesmultitables.dao.CategoryDao;
import com.example.module12mvccrudmultipagesmultitables.dao.ProductDao;
import com.example.module12mvccrudmultipagesmultitables.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    public List<Category> findAll(String name) {

        if(name != null) {
            return this.categoryDao.findByName(name);
        }
        return this.categoryDao.findAll();
    }

    public Category findById(int id) {
        return this.categoryDao.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        this.categoryDao.deleteById(id);
    }

    public void saveCategory(Category category) {
        if (category.getId() == 0) {
            this.categoryDao.save(category);
        } else {
            Category c = findById(category.getId());
            c.setName(category.getName());
            this.categoryDao.save(c);
        }
    }
}
