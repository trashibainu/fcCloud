package com.feichai.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

//    @Pointcut("execution(* com.feichai.test.service..*.*(..))")
    @Pointcut("@annotation(com.feichai.test.annotation.Trashibainu)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("------------------"+"before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("------------------"+"after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("------------------"+"afterReturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("------------------"+"afterThrowing");
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
