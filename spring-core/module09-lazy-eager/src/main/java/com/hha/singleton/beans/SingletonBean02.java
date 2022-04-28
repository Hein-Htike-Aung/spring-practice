package com.hha.singleton.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SingletonBean02 {

    private SingletonBean01 singletonBean01;

    public SingletonBean02(@Lazy SingletonBean01 singletonBean01) {
        this.singletonBean01 = singletonBean01;
    }

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + " -> " + this.singletonBean01);
    }

}
