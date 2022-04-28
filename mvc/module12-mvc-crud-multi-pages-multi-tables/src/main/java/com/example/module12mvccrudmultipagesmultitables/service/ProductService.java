package com.example.module12mvccrudmultipagesmultitables.service;

import com.example.module12mvccrudmultipagesmultitables.dao.CategoryDao;
import com.example.module12mvccrudmultipagesmultitables.dao.ProductDao;
import com.example.module12mvccrudmultipagesmultitables.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll(String keyword) {
        if (keyword == null) {
            return this.productDao.findAll();
        } else {
            return this.productDao.findByKeyword(keyword);
        }
    }

    public Product findById(int id) {
        return this.productDao.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        this.productDao.deleteById(id);
    }

    public void save(Product product) {
        if (product.getId() == 0) {
            this.productDao.save(product);
        } else {
            Product p = findById(product.getId());
            p.setName(product.getName());
            p.setCategory(product.getCategory());
            p.setPrice(product.getPrice());
            p.setQuantity(product.getQuantity());
            this.productDao.save(p);
        }
    }
}
