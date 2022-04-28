package com.example.counterservice.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestBodyCounter {

    private int number;

    public RequestBodyCounter(@JsonProperty("number") int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
