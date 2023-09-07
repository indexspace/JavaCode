package com.log;

import org.aspectj.lang.annotation.*;

@Aspect

public class annotion {

    @Pointcut("execution(* com.service.User.*(..))")
    public void log(){
    }

    @Before("log()")
    public void before(){
        System.out.println("==aop注解before==");
    }

    @After("log()")
    public void after(){
        System.out.println("==aop注解after==");
    }

}
