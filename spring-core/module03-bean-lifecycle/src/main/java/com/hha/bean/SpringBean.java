package com.hha.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean implements InitializingBean, DisposableBean {

    private Bean01 bean01;

    private Bean02 bean02;

    public SpringBean(Bean01 bean01, Bean02 bean02) {
        System.out.println(getClass().getSimpleName() + " :: Constructor");
    }

    @Autowired
    public void setBean01(Bean01 bean01) {
        this.bean01 = bean01;
        System.out.println(getClass().getSimpleName() + " :: setBean01");
    }

    @Autowired
    public void setBean02(Bean02 bean02) {
        this.bean02 = bean02;
        System.out.println(getClass().getSimpleName() + " :: setBean02");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(getClass().getSimpleName() + " :: PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(getClass().getSimpleName() + " :: PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(getClass().getSimpleName() + " :: InitializingBean.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(getClass().getSimpleName() + " :: DisposableBean.destroy");
    }

    public void initMethod() {
        System.out.println(getClass().getSimpleName() + " :: @Bean.initMethod");
    }

    public void destroyMethod() {
        System.out.println(getClass().getSimpleName() + " :: @Bean.destroyMethod");
    }
}
