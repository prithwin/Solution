package com.design.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by prajeeva on 10/16/17.
 */
public class MyProxy implements InvocationHandler {

    Object[] things;

    MyProxy(Object[] things ){
        this.things = things;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return 43;
    }
}
