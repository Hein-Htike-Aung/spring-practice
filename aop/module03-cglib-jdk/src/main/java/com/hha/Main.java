package com.hha;


import com.hha.beans.JDKDynamicProxy;

import com.hha.beans.JDKDynamicProxyImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        CGILIBProxyBean cgilibProxyBean = context.getBean(CGILIBProxyBean.class);
        JDKDynamicProxy jdkDynamicProxy = context.getBean(JDKDynamicProxy.class);

        // Change to CGLIB Proxy
//        JDKDynamicProxyImpl jdkDynamicProxyImpl = context.getBean(JDKDynamicProxyImpl.class);

        cgilibProxyBean.publicMethod();
        cgilibProxyBean.protectedMethod();
        cgilibProxyBean.noModifierMethod();

        System.out.println("===========================");

        jdkDynamicProxy.publicMethod();

    }
}
