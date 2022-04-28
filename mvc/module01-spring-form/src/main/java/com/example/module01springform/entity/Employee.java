package com.example.module01springform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    @Min(500)
    private double salary;

    public Employee() {
    }
}
