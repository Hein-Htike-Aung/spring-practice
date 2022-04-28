package com.example.module12mvccrudmultipagesmultitables.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
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
        products.forEach(product -> product.setCategory(this));
        this.productList.addAll(products);
    }

    public void removeAllProducts() {
        this.productList.forEach(product -> product.setCategory(null));
        this.productList.clear();
    }

    public Category() {
    }
}
