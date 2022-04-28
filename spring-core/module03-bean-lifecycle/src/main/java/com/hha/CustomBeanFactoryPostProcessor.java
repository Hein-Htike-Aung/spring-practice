package com.hha;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        System.out.println("\n==========================\n");

        Arrays.stream(configurableListableBeanFactory.getBeanDefinitionNames())
                .forEach(System.out::println);

        System.out.println("\n==========================\n");


    }
}
