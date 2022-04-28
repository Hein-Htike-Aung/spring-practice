package com.example.module04onetomany.com.hha.service;

import com.example.module04onetomany.com.hha.dao.CategoryDao;
import com.example.module04onetomany.com.hha.dao.ProductDao;
import com.example.module04onetomany.com.hha.entity.Category;
import com.example.module04onetomany.com.hha.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    public Category findById(int id) {
        return categoryDao.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        categoryDao.deleteById(id);
    }

    public void updateCategory() {
        Category category = findById(1);
        category.setName("Vehicle");
        categoryDao.save(category);
    }

    @Transactional
    public void saveCategories() {
        Category category = new Category();
        category.setName("Electronic Devices");
        Category category2 = new Category();
        category2.setName("Home Appliances");
        Category category3 = new Category();
        category3.setName("Self Care");

        categoryDao.save(category);
        categoryDao.save(category2);
        categoryDao.save(category3);
    }

    @Transactional
    public void saveCategoryWithProducts() {
        Category category = categoryDao.fetchName("Electronic Devices");

        Product product = new Product();
        product.setName("Apple");
        product.setPrice(7000);
        product.setQuantity(10);

        Product product2 = new Product();
        product2.setName("One Plus");
        product2.setPrice(8000);
        product2.setQuantity(10);

        category.addProducts(List.of(product, product2));

        categoryDao.save(category);
    }


}
