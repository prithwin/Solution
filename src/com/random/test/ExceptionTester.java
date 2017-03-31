package com.random.test;

/**
 * Created by pr250155 on 3/28/17.
 */
public class ExceptionTester {

    public static int test(int i) {
        try {
            System.out.println("tryblock");
            if (i == 0)
                throw new Exception();
            return 0;
        } catch (Exception e) {
            System.out.println("exception caught");
            return 1;
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(test(0));
        System.out.println(test(1));
    }
}
