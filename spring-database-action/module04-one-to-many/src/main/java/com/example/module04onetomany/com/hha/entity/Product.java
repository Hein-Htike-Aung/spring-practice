package com.example.module04onetomany.com.hha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int price;

    private int quantity;

    @ManyToOne
    private Category category;

    public Product() {
    }
}
