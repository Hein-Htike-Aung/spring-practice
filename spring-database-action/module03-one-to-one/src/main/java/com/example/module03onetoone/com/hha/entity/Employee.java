package com.example.module03onetoone.com.hha.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phone;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    private BiographicalInfo biographicalInfo;

    public Employee() {
    }

}
