package com.hha.singleton.beans;

import org.springframework.stereotype.Component;

@Component
public class SuperBean {

    private final Inter inter;

    public SuperBean(Inter inter) {
        this.inter = inter;
    }

    public void print() {
        inter.interMethod();
    }
}
