package com.random.test.old;

/**
 * Created by pr250155 on 3/29/17.
 */
public class ThreadTesterStartRun {
    public static void main(String[] args) throws InterruptedException {
//        MyThread thread = new MyThread();
//        thread.doSomething();
        Thread otherThread = new Thread(() -> {
            Thread.currentThread().start();
        });

    }
}

class MyThread extends Thread {
    MyThread(){
        start();
    }
    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }

    public void doSomething() throws InterruptedException {
        join();
    }
}
