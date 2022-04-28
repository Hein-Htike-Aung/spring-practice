package com.hha;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(String.format("postProcessBeforeInitialization :: [%s] -> [%s]",
                bean.getClass().getSimpleName(),
                beanName));

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


        System.out.println(String.format("postProcessAfterInitialization :: [%s] -> [%s]",
                bean.getClass().getSimpleName(),
                beanName));

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
