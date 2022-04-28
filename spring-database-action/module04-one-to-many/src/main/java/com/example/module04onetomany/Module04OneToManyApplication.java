package com.example.module04onetomany;

import com.example.module04onetomany.com.hha.entity.Category;
import com.example.module04onetomany.com.hha.entity.Product;
import com.example.module04onetomany.com.hha.service.CategoryService;
import com.example.module04onetomany.com.hha.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Module04OneToManyApplication implements CommandLineRunner {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(Module04OneToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        System.out.println("\nSave Category");
        categoryService.saveCategories();
//
//        System.out.println("\nFind All Category");
//        printAllCategories();
//
//        System.out.println("\nUpdate Category");
//        categoryService.updateCategory();
//
//        System.out.println("\nFind Category Id = 1");
//        Category category = categoryService.findById(1);
//        System.out.println(category.getName());
//
//        System.out.println("\nDelete Category Id = 1");
//        categoryService.deleteById(1);
//
//        System.out.println("\nFind All Category");
//        printAllCategories();

        System.out.println("Save Product With Category");
        productService.save();

        System.out.println("\nSave Category With Products");
        categoryService.saveCategoryWithProducts();

        System.out.println("\nfind All Products");
        printAllProducts();
    }

    private void printAllCategories() {
        List<Category> categories = categoryService.findAll();
        categories.stream().map(category -> category.getName()).forEach(System.out::println);
    }

    private void printAllProducts() {
        List<Product> productList = productService.findAll();
        productList.stream().map(product -> product.getCategory().getName() + " : " + product.getName()).forEach(System.out::println);
    }
}
