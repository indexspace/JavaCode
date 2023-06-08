package com.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class afterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("=====对象:" + target.getClass().getName()
                +",方法:"+method.getName()
                +",返回值："+returnValue+"====="
        );
    }
}
