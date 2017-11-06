package com.java.rules;

/**
 * Created by prajeeva on 11/2/17.
 */
public class Change {

    public static void main(String[] args) {
        //this is what is going to happen
        int a = 4;
        foo(a);
        System.out.println(a);
    }

    private static void foo(int a) {
        a++;
        a++;
        a++;
        a++;a++;a++;a++;
    }
}
