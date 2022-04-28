package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CGILIBProxyBeanAspect {

    @Pointcut("within(com.hha.*)")
    public void beforePointCut(){}

    @Before("beforePointCut()")
    public void beforeExecution(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
    }
}
