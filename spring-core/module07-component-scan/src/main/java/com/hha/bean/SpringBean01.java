package com.hha.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpringBean01 {

    private final SpringBean02 springBean02;

    private final SpringBean03 springBean03;

    public SpringBean01(
            @Nullable SpringBean02 springBean02,
            @Nullable SpringBean03 springBean03
    ) {
        this.springBean02 = springBean02;
        this.springBean03 = springBean03;
    }

    @PostConstruct
    public void init() {
        System.out.println(springBean02);
        System.out.println(springBean03);
    }
}
