package com.hha;

import com.hha.bean.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        SpringBean springBean = context.getBean(SpringBean.class);
    }
}
