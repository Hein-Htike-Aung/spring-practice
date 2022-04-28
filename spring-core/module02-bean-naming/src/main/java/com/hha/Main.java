package com.hha;

import com.hha.singleton.beans.SuperBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();


        context.getBean(SuperBean.class).print();
    }
}
