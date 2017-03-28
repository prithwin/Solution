package com.random.test;

/**
 * Created by pr250155 on 3/28/16.
 */
public class VarargsTest {
    public static void main(String[] args) {
        B b = new B();
        b.doAThing(0);
    }
}

class B {
    public void doAThing(int i,String... s){
        System.out.println("doing B thing");
    }
}