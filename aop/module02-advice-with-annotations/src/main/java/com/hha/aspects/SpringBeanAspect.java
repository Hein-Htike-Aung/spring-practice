package com.hha.aspects;

import com.hha.annotations.BeforeInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringBeanAspect {

    @Before("@annotation(com.hha.annotations.BeforeInvocation)")
    public void beforeExecution() {
        System.out.println("\nBefore Execution");
    }

    @After("@annotation(com.hha.annotations.AfterInvocation)")
    public void afterExecution() {
        System.out.println("After Execution\n");
    }

    @Around("@annotation(com.hha.annotations.AroundInvocation)")
    public Object aroundInvocation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("\nBefore Execution");
        try{
            return proceedingJoinPoint.proceed();
        }finally {
            System.out.println("After Execution\n");
        }
    }
}
