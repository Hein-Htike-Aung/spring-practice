package com.example.module07transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    private LocalDate hireDate;

    private double salary;

    public Employee() {
    }

    public Employee(String name, LocalDate hireDate, double salary) {
        this.name = name;
        this.hireDate = hireDate;
        this.salary = salary;
    }
}
