package com.example.module06tableinheritance.com.hha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@AllArgsConstructor
@Data
@Inheritance
@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Member{

    private double salary;

    public Employee() {
    }
}
