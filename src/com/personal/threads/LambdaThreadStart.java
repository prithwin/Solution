package com.personal.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 4/3/17.
 */
public class LambdaThreadStart {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        A a = new A();
        B b = new B();
        C c = new C();
        CountDownLatch latch = new CountDownLatch(1);

        Thread threadA = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.doA(lock);
            b.doB(lock);
            c.doC(lock);
        });
        Thread threadB = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.doA(lock);
            b.doB(lock);
            c.doC(lock);
        });
        Thread threadC = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.doA(lock);
            b.doB(lock);
            c.doC(lock);
        });
        threadA.start();
        threadB.start();
        threadC.start();
        latch.countDown();
    }
}
class A {
    public void doA(Lock l){
        l.lock();
        System.out.println("doing A");
        l.unlock();
    }
}

class B {
    public void doB(Lock l){
        l.lock();
        System.out.println("doing B");
        l.unlock();
    }
}

class C {
    public void doC(Lock l){
        l.lock();
        System.out.println("doing C");
        l.unlock();
    }
}
