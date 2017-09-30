package com.personal.threads;

/**
 * Created by prajeeva on 9/18/17.
 */
public class EvenOddPrinterLangLevel {
    private static class NoticeBoard {
        boolean even=false;

        public synchronized void print(int n) {
            while (n%2 == 0 && !even || n%2 != 0 && even) try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(n);
            even = ! even;
            notify();
        }
    }

    public static void main(String[] args) {
        NoticeBoard b = new NoticeBoard();
        new Thread(() -> {
            for(int i = 1 ; i < 100 ; i+=2) b.print(i);
        }).start();
        new Thread(() -> {
            for(int i = 2 ; i < 100 ; i+=2) b.print(i);
        }).start();
    }
}
