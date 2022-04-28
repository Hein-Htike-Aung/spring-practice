package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CGLIBProxyBeanAspect {

    @Pointcut("this(com.hha.beans03.CGILIBProxyBean)")
    public void thisPointCut() {}

    @Before("thisPointCut()")
    public void beforeExecution(JoinPoint joinPoint) {

        System.out.println(joinPoint.getSignature());

    }
}
