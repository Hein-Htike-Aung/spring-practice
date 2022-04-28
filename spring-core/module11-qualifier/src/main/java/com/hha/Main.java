package com.hha;

import com.hha.service.FieldQualifierService;
import com.hha.service.FieldQualifierService02;
import com.hha.service.FieldQualifierService03;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        context.getBean(FieldQualifierService.class).print();
        context.getBean(FieldQualifierService02.class).print();
        context.getBean(FieldQualifierService03.class).print();
    }
}
