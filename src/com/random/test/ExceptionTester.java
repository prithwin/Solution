package com.random.test;

/**
 * Created by pr250155 on 3/28/17.
 */
public class ExceptionTester {
    public String one = "one";

    public static void main(String[] args) {
        System.out.println(new ExceptionTester().one == new Z().one);
    }

}