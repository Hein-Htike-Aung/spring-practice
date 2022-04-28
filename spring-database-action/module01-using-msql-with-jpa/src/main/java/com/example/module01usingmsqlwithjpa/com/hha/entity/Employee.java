package com.example.module01usingmsqlwithjpa.com.hha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Employee() {
    }
}
