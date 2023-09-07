package com.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class beforeLog implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        if (o != null) {
            System.out.println("=====对象:" + o.getClass().getName()
                    +",方法:"+method.getName()+"====="
            );
        }
    }
}
