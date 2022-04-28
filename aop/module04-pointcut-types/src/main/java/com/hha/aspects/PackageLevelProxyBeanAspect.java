package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PackageLevelProxyBeanAspect {

    @Pointcut("within(com.hha.beans02.*)")
    public void withinPointCut() {}

    @Before("withinPointCut()")
    public void beforeExecution(JoinPoint joinPoint) {

        System.out.println(joinPoint.getSignature());
    }
}
