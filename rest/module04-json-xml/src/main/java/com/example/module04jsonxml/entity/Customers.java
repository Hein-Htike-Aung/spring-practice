package com.example.module04jsonxml.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@JacksonXmlRootElement(localName = "customers")
public class Customers {

    @JacksonXmlProperty(localName = "customer")
    private List<Customer> customers = new ArrayList<>();

    public Customers(Iterable<Customer> customers) {

        this.customers = StreamSupport.stream(customers.spliterator(), false)
                .collect(Collectors.toList());

    }
}
