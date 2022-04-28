package com.hha.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PropertyReaderBean {


    @Value("${app.value}")
    private String appValue;

    @Value("${app.value2}")
    private String appValue2;

    // -Dapp.vmValue=applicationVMValue
    @Value("${app.vmValue}")
    private String vmProperty;

    @PostConstruct
    public void init() {
        System.out.println(appValue);
        System.out.println(appValue2);
        System.out.println(vmProperty);
    }
}
