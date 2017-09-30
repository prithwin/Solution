package com.random.test;

/**
 * Created by pr250155 on 4/12/17.
 */
public class RecursiveTester {
    public static void main(String[] args) {
        System.out.println(callRecursive(1));
    }

    private static int callRecursive(int i) {
        System.out.println(i);
        return callRecursive(i+1);
    }
}
