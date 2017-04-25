package com.random.test;

/**
 * Created by pr250155 on 4/23/17.
 */
public class InitializerTest {
    static int staticvalue = getStaticValue();

    {
       System.out.println((staticvalue++) + ".Instance block executed");
    }
    int value = getValue();

    static {
        System.out.println((staticvalue++) + ".Static block run");
    }

    public InitializerTest(){
        System.out.println((staticvalue++) + ".constructor");
    }

    public static void main(String[] args) {
        InitializerTest test = new InitializerTest();
    }

    public int getValue() {
        System.out.println((staticvalue++) + ".Intitializing a variable");
        return 0;
    }

    public static int getStaticValue() {
        System.out.println(1+".Intitializing a variable in static method");
        return 2;
    }
}
