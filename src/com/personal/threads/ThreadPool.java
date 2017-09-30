package com.personal.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 5/24/17.
 */
public class ThreadPool implements Runnable {
    int availableSlots;
    int theoreticalMax;
    Lock threadPoolLock = new ReentrantLock();
    Condition boundryCondition = threadPoolLock.newCondition();
    boolean running;
    BlockingQueue<Runnable> q;

    public ThreadPool(int size) {
        this.availableSlots = size;
        this.theoreticalMax = size;
        q = new ArrayBlockingQueue<>(size);
    }

    public void execute(Runnable thread) throws InterruptedException {
        if(!running) {
            synchronized (this) {
                q.put(thread);
            }
        } else {
            running = true;
            q.put(thread);
            new Thread(this).start();
        }
    }

    @Override
    public void run() {
        while(true) {
            Runnable r = null;
            try {
                r = q.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = new Thread(r);
            threadPoolLock.lock();
            while (availableSlots == 0) {
                try {
                    boundryCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            thread.start();
            availableSlots--;
            threadPoolLock.unlock();
            new Thread(() -> {
                while (thread.isAlive()) {

                }
                this.threadPoolLock.lock();
                this.availableSlots += 1;
                this.boundryCondition.signal();
                this.threadPoolLock.unlock();
            }).start();
        }
    }
}
