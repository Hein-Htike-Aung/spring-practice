package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ArgumentLevelProxyBeanAspect {

    @Pointcut("args(String, String, ..)")
    public void argsPointCut() {
    }

    @Before("argsPointCut()")
    public void beforeExecution(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
    }

    @Pointcut("@args(com.hha.annotations.ArgumentLevelProxyAnnotation)")
    public void atArgsPointCut() {
    }

    @Before("atArgsPointCut()")
    public void beforeExecution02(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
    }

    @Pointcut("argsPointCut() && atArgsPointCut()")
    public void mixturePointCut() {
    }
}
