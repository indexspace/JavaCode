package com.log;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect

public class annotion {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
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
