package com.example.module02usinghsqldbwithjdbctemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@Data
@ToString
public class Employee {

    private int id;

    private String name;

    private Date hireDate;

    private double salary;

    public Employee() {
    }
}
