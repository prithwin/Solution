package com.random.test;

import java.io.IOException;

/**
 * Created by pr250155 on 3/28/17.
 */
public class ExceptionTester {

    public static int test(int i) {
       return i;
    }

    public static void main(String[] args) {
        System.out.println(test(0));
        System.out.println(test(1));
    }
}
