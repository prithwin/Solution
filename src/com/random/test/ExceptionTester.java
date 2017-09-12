package com.random.test;

/**
 * Created by pr250155 on 3/28/17.
 */
public class ExceptionTester {
    public String one = "one";

    public static void main(String[] args) {
        System.out.println(new ExceptionTester().excep(3));
    }

    public int excep(int val ) {
        try {
            System.out.println("int the try block");
          throw new Exception();
        }catch ( Exception e) {
            System.out.println("int the catch block");
            throw new Exception();
        } finally {
            System.out.println("in finally");
            return 3;
        }
        //return 1;
    }

}