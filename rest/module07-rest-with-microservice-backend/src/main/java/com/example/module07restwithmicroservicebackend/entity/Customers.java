package com.example.module07restwithmicroservicebackend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@AllArgsConstructor
public class Customers {

    private List<Customer> customerList;

    public Customers() {
    }

    public Customers(Spliterator<Customer> customerSpliterator) {
        this.customerList = StreamSupport.stream(customerSpliterator, false)
                .collect(Collectors.toList());
    }

}
