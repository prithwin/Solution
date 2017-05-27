package com.personal.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by prajeev on 14/3/17.
 */
public class DeadlockCreator {


     static class X {
         Lock lockX = new ReentrantLock();
         Condition xDoable = lockX.newCondition();

         public void doX(){
             lockX.lock();
             try {
                 xDoable.await();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             xDoable.signalAll();
             System.out.println("doingX");
             lockX.unlock();
         }
     }



    public static void main(String[] args) {
        X x = new X();
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x.doX();}).start();  //Thread A
        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x.doX();}).start();  //Thread B
        latch.countDown();
        x.lockX.lock();
        x.xDoable.signalAll();
        x.lockX.unlock();

    }
}
