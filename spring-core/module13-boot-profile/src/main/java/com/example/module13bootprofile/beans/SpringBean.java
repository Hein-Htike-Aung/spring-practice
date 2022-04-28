package com.example.module13bootprofile.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpringBean {


    @Value("${db.host}")
    private String dbHost;

    @Value("${app.home.value}")
    private String appHomeValue;

    @PostConstruct
    public void init() {
        System.out.println(dbHost);

        System.out.println(appHomeValue);
    }

}
