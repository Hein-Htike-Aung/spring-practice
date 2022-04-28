package com.hha;

import com.hha.singleton.beans.MultiProfileBean;
import com.hha.singleton.beans.SingleProfile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

//        context.getEnvironment().setActiveProfiles("db");
         context.getEnvironment().setActiveProfiles("mysql");
        context.register(Config.class);
        context.refresh();

        System.out.println(context.getBean(MultiProfileBean.class).getClass().getSimpleName());
        System.out.println(context.getBean(SingleProfile.class).getClass().getSimpleName());
    }
}
