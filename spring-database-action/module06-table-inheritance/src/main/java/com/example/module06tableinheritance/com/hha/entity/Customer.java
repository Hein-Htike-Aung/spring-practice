package com.example.module06tableinheritance.com.hha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Data
@AllArgsConstructor
@Inheritance
@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends Member{

    private String profession;

    public Customer() {

    }


}
