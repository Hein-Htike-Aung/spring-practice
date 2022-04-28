package com.example.module12mvccrudmultipagesmultitables.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    @Min(100)
    private double price;

    @Min(1)
    private int quantity;

    @ManyToOne
    @NotNull(message = "Must Choose Product's Category")
    private Category category;

    public void addCategory(Category category) {
        this.setCategory(category);
    }

    public void removeCategory(Category category) {
        this.setCategory(null);
    }

    public Product() {
    }
}
