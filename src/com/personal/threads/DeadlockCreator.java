package com.personal.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by prajeev on 14/3/17.
 */
public class DeadlockCreator {
    private static class B {
        int b;

        public synchronized void updateB() {
            while(b < 100) try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b++;
            System.out.println(b);
        }
    }
    private static class A {
        B bee;
        int a;

        public synchronized void updateA() {
            bee.updateB();
            a++;
            System.out.println(a);
        }

        public synchronized void shout() {
            System.out.println("AaAAAAAAAAAAAAAAAAaaAAAAAAAAAAaaaAAAAA");
        }
    }


   public static void main(String[] args) {
       A a = new A();
       new Thread(() -> {while(true) a.shout();}).start();
       a.bee = new B();
       a.updateA();

   }
}
