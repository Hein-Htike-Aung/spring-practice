package com.hha;

import com.hha.beans.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        context.getBean(SpringBean.class).sayHello("Quantum!!!");
        context.getBean(SpringBean.class).noReturnSayHello();
        context.getBean(SpringBean.class).aroundAspectMethod("Xiaoting");

        try{
            context.getBean(SpringBean.class).throwingException();
        }catch (Exception e) {
            System.out.println("Exception In Main");
        }


    }
}
