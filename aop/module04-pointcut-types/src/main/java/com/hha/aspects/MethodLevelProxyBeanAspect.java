package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLevelProxyBeanAspect {

    @Pointcut("@annotation(com.hha.annotations.MethodLevelProxyAnnotation)")
    public void annotationPointCut() {}

    @Before("annotationPointCut()")
    public void beforeExecution(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
    }

    @Pointcut("execution(* com.hha.beans.MethodLevelProxyBean.execution(..))")
    public void executionPointCut() {}

    @Before("executionPointCut()")
    public void beforeExecution02(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
    }
}
