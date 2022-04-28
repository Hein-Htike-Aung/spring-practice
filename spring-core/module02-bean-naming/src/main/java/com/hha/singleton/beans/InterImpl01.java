package com.hha.singleton.beans;

import org.springframework.stereotype.Component;

@Component
public class InterImpl01 implements Inter{

    @Override
    public void interMethod() {
        System.out.println(getClass().getSimpleName() + " :: interMethod");
    }
}
