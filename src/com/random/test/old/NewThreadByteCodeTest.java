package com.random.test.old;

/**
 * Created by prajeeva on 10/29/17.
 */
public class NewThreadByteCodeTest {
    public static void main(String[] args) {
        System.out.println("THis is happening in the main thread");
        new Thread(() -> {
            System.out.println("This is not happening in the main thread");
        }).start();
    }
}
