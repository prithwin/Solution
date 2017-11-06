package com.design.patterns.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by prajeeva on 10/16/17.
 */
public class ProxyRunner {
    public static void main(String[] args) {
        ProxyRunner runner = new ProxyRunner();
        SomeClassService inst = (SomeClassService) Proxy.newProxyInstance(
                runner.getClass().getClassLoader(),
                new Class[] {SomeClassService.class},
                new MyProxy(new Object[]{})
        );
        System.out.println("hold on lets see what happened there");
        System.out.println("something must have happened here");

        System.out.println(inst.doSomeOtherThing("somthing" ,56));


    }
}
