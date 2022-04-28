package com.hha.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpringBean {

    @Value("${app.env}")
    private String appEnv;

    @Value("${app.home.value}")
    private String appHomeValue;

    @PostConstruct
    public void init() {
        System.out.println(appEnv);

        System.out.println(appHomeValue);
    }
}
