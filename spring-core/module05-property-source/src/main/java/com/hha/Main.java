package com.hha;

import com.hha.bean.PropertyReaderBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();



        context.getBean(PropertyReaderBean.class);
    }
}
