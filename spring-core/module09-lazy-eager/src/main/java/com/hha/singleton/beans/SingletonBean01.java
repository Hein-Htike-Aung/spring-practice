package com.hha.singleton.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy
public class SingletonBean01 {

    private SingletonBean02 singletonBean02;

    public SingletonBean01(SingletonBean02 singletonBean02) {
        this.singletonBean02 = singletonBean02;
    }

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + " -> " + this.singletonBean02);
    }

}
