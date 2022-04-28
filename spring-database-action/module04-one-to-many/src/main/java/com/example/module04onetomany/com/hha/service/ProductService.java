package com.example.module04onetomany.com.hha.service;

import com.example.module04onetomany.com.hha.dao.CategoryDao;
import com.example.module04onetomany.com.hha.dao.ProductDao;
import com.example.module04onetomany.com.hha.entity.Category;
import com.example.module04onetomany.com.hha.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    public void save() {

        Optional<Category> category = categoryDao.findById(1);

        Product product = new Product();
        product.setName("Xiaomi");
        product.setPrice(4000);
        product.setQuantity(10);
        product.setCategory(category.orElse(null));

        productDao.save(product);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteAllProductsByCategory() {
        Category category = categoryDao.fetchName("Electronic Devices");

        category.removeAllProduct();
    }

    public void deleteProductByCategory() {
        Category category = categoryDao.fetchName("Electronic Devices");

        category.removeProduct(productDao.findById(1).orElse(null));
    }

}
