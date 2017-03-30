package com.random.test;

/**
 * Created by pr250155 on 3/28/17.
 */
public class ExceptionTester {
    public static void main(String[] args) {
        System.out.println(new ExceptionTester().getIntfo());
        ExceptionTester e = null;
        e.getIntfo();
    }

    private static int getIntfo() {
        try{
            System.out.println("this that");
            return 1;
        } catch (Exception e){
            return 7;
        } finally {
            return 10;
        }
    }
}
