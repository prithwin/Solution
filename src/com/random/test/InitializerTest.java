package com.random.test;

/**
 * Created by pr250155 on 4/23/17.
 */
public class InitializerTest {
    {
       System.out.println("Instance block executed");
        System.out.println(staticvalue);
    }

    int value = getValue();
    static int staticvalue = getStaticValue();
    private int staticValue;

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
