package com.example.module04onetomany.com.hha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        product.setCategory(this);
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
        product.setCategory(null);
        this.productList.remove(product);
    }

    public void addProducts(List<Product> products) {

        products.forEach(p -> {
            p.setCategory(this);
            this.productList.add(p);
        });

    }

    public void removeAllProduct() {
        Iterator<Product> productIterable = this.productList.iterator();

        while(productIterable.hasNext()) {
            Product product = productIterable.next();
            product.setCategory(null);
            productIterable.remove();
        }
    }

    public Category() {
    }
}
