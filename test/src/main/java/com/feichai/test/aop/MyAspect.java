package com.feichai.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class MyAspect {

    @Pointcut("execution(com.feichai.test.service.AopService.(*))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){

    }

    @After("")
    public void after(){

    }

    @AfterReturning("")
    public void afterReturning(){

    }

    @AfterThrowing("")
    public void afterThrowing(){

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object object = null;
        System.out.println("Before Around...");
        object = proceedingJoinPoint.proceed();
        System.out.println("After Around...");
        return object;
    }

}
