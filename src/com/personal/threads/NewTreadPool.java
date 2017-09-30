package com.personal.threads;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by prajeeva on 9/18/17.
 */
public class NewTreadPool {
    private static class Runner implements Runnable {
        int id = 0;
        Runner(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            System.out.println(id);
        }
    }

    LinkedBlockingQueue<Thread> threadQueue = new LinkedBlockingQueue<>(10);
    int MAX_R = 5;
    int r = 0;

    public synchronized void submit(Thread t) throws InterruptedException {
        threadQueue.put(t);
    }


    public void execute() throws InterruptedException {
        while(true) {
            Thread target = threadQueue.take();
        }
    }

}
