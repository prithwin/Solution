package com.personal.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 5/24/17.
 */
public class ThreadPool {
    int availableSlots;
    int theoreticalMax;
    Lock threadPoolLock = new ReentrantLock();
    Condition boundryCondition = threadPoolLock.newCondition();

    public ThreadPool(int size) {
        this.availableSlots = size;
        this.theoreticalMax = size;
    }

    public void execute(Thread thread) throws InterruptedException {
        threadPoolLock.lock();
        while (availableSlots == 0) {
            boundryCondition.await();
        }
        thread.start();
        availableSlots--;
        threadPoolLock.unlock();
        new Thread(new ThreadMonitor(this, thread)).start();
    }

    static class ThreadMonitor implements Runnable {
        ThreadPool threadPool;
        Thread thread;

        public ThreadMonitor(ThreadPool pool, Thread thread) {
            this.threadPool = pool;
            this.thread = thread;
        }

        @Override
        public void run() {
            while (thread.isAlive()) {

            }
            threadPool.threadPoolLock.lock();
            threadPool.availableSlots += 1;
            threadPool.boundryCondition.signal();
            threadPool.threadPoolLock.unlock();
        }
    }
}
