package com.hha;

import com.hha.singleton.beans.SpringBean01;
import com.hha.singleton.beans.SpringBean02;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        System.out.println(context.getBean(SpringBean01.class));
        System.out.println(context.getBean(SpringBean01.class));
        System.out.println(context.getBean(SpringBean01.class));

        System.out.println("=======================");

        System.out.println(context.getBean(SpringBean02.class));
        System.out.println(context.getBean(SpringBean02.class));
        System.out.println(context.getBean(SpringBean02.class));

    }
}
