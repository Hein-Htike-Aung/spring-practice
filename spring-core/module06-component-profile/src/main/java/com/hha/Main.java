package com.hha;

import com.hha.singleton.beans.MultiProfile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("DB", "Production");
//        context.getEnvironment().setActiveProfiles("InMemory");
        context.register(Config.class);
        context.refresh();

        System.out.println(context.getBean(MultiProfile.class).getClass().getSimpleName());
    }
}
