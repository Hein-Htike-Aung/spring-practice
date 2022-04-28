package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JDKDynamicProxyAspect {

    @Pointcut("target(com.hha.beans03.JDKDynamicProxy)")
    public void targetPointCut() {}

    @Before("targetPointCut()")
    public void beforeExecution(JoinPoint joinPoint) {

        System.out.println(joinPoint.getSignature());

    }

    @Pointcut("@target(com.hha.annotations.TargetClassLevelProxyAnnotation)")
    public void atTargetPointCut() {}

    @Before("atTargetPointCut()")
    public void beforeExecution02(JoinPoint joinPoint) {

        System.out.println(joinPoint.getSignature());
    }
}
