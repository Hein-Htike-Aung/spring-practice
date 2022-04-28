package com.hha.aspects;

import com.hha.beans.SpringBean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringBeanAspect {


    @Before("execution(public String com.hha.beans.SpringBean.sayHello(*))")
    public void beforeAdvice(JoinPoint joinPoint) {

        System.out.println("\n=================Before Advice============");

        System.out.println("Parameter value = " + joinPoint.getArgs()[0]);
    }

    @After("execution(public void com.hha.beans.SpringBean.noReturnSayHello(..))")
    public void afterAdvice(JoinPoint joinPoint) {

        System.out.println("\n=================After Advice============");

        System.out.println(joinPoint.getSignature());
    }

    @AfterThrowing(value = "execution(* com..SpringBean.throwingException())", throwing = "e")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception e) {

        System.out.println("\n=================After Throwing Advice============");
        System.out.println("Exception Message -> " + e.getMessage());

    }

    @AfterReturning(value = "execution(public String com.hha.beans.SpringBean.sayHello(..))", returning = "returnValue")
    public void afterReturingAdvice(JoinPoint joinPoint, Object returnValue) {

        System.out.println("\n=================After Returning Advice============");
        System.out.println("Return Value = " + returnValue);

    }

    @Around("execution(* com..beans.SpringBean.aroundAspectMethod(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("\n=================Around Advice============");

        System.out.println("Before Method Execution");
        System.out.println("Parameter value = " + proceedingJoinPoint.getArgs()[0]);
        Object returnValue = null;

        try {
            returnValue = proceedingJoinPoint.proceed();
            return returnValue;

        } finally {
            System.out.println("Return value = " + returnValue);
            System.out.println("After Method Execution");
        }

    }

}
