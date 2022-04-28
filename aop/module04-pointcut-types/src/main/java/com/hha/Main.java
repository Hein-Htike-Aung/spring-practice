package com.hha;

import com.hha.beans.ArgumentLevelProxyBean;
import com.hha.beans.BeanLevelProxyBean;
import com.hha.beans.ClassLevelProxyBean;
import com.hha.beans.MethodLevelProxyBean;
import com.hha.beans02.PackageLevelProxyBean;
import com.hha.beans02.PackageLevelProxyBean02;
import com.hha.beans03.CGILIBProxyBean;
import com.hha.beans03.JDKDynamicProxy;
import com.hha.ds.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        System.out.println("\n==========Package Level===========");
        context.getBean(PackageLevelProxyBean.class).within();
        context.getBean(PackageLevelProxyBean02.class).within();

        System.out.println("\n==========Class Level===========");
        context.getBean(ClassLevelProxyBean.class).atWithin();
        context.getBean(ClassLevelProxyBean.class).atWithin02();

        System.out.println("\n==========Bean Level===========");
        context.getBean(BeanLevelProxyBean.class).bean();
        context.getBean(BeanLevelProxyBean.class).bean02();

        System.out.println("\n==========CGLIB===========");
        context.getBean(CGILIBProxyBean.class).this01();

        System.out.println("\n==========JDK based===========");
        context.getBean(JDKDynamicProxy.class).target();

        System.out.println("\n==========Method Level===========");
        context.getBean(MethodLevelProxyBean.class).annotation();
        context.getBean(MethodLevelProxyBean.class).execution();

        System.out.println("\n==========Argument Level===========");
        context.getBean(ArgumentLevelProxyBean.class).atArgs( new Employee());
        context.getBean(ArgumentLevelProxyBean.class).args("Xiaoting", "Karina", 23);

    }
}
