package com.hha;

import com.hha.prototype.beans.PrototypeBean01;
import com.hha.prototype.beans.PrototypeBean02;
import com.hha.singleton.beans.SingletonBean01;
import com.hha.singleton.beans.SingletonBean02;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.registerShutdownHook();

        context.getBean(SingletonBean01.class);
        context.getBean(SingletonBean02.class);

        context.getBean(PrototypeBean01.class).print();
        context.getBean(PrototypeBean02.class).print();
    }
}
