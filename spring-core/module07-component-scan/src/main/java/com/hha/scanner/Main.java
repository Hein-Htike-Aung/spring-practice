package com.hha.scanner;

import com.hha.bean.SpringBean01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        context.getBean(SpringBean01.class);
    }
}
