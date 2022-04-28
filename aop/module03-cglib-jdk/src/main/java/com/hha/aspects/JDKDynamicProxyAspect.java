package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JDKDynamicProxyAspect {

    @Pointcut("within(com.hha.beans.*)")
    private void afterPointCut(){}

    @After("afterPointCut()")
    public void afterExecution(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
    }
}
