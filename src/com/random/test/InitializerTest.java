package com.random.test;

/**
 * Created by pr250155 on 4/23/17.
 */
public class InitializerTest {
    static int staticvalue = getStaticValue();

    {
       System.out.println("Instance block executed");
    }
    int value = getValue();

    static {
        System.out.println("Static block run");
    }

    public InitializerTest(){
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        InitializerTest test = new InitializerTest();
    }

    public int getValue() {
        System.out.println("Intitializing a variable");
        return 0;
    }

    public static int getStaticValue() {
        System.out.println("Intitializing a variable in static method");
        return 1;
    }
}
