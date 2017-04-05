package com.random.test;

/**
 * Created by pr250155 on 3/28/17.
 */
public class ExceptionTester {

    public static int test(int i) {
        try{
            System.out.printf("hi in try");
            throw new Exception();
            //System.exit(1);
        } catch (Exception e){
            System.out.printf("hi in catch");
            //System.exit(1);
            throw new Exception();
        }finally {
            System.out.println("Hi in Finally");
            System.exit(1);
            return i;
        }
    }

    public static void main(String[] args) {
        System.out.println(test(0));
        System.out.println(test(1));
    }
}
