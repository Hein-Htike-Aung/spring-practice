package com.hha;


import com.hha.beans.SpringBean01;
import com.hha.beans.SpringBean02;
import com.hha.beans.SpringBean03;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        context.getBean(SpringBean01.class).print();
        context.getBean(SpringBean02.class).print();
        context.getBean(SpringBean03.class).print();

    }
}
