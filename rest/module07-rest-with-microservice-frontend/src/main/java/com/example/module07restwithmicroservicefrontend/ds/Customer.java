package com.example.module07restwithmicroservicefrontend.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {

    private int id;

    private String customerName;

    public Customer() {
    }
}
