package com.personal.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by prajeev on 10/3/17.
 */
public class BlockingQueue {
    private List<Integer> q = new ArrayList<>();
    private int SIZE = 5;
    private Lock lock = new ReentrantLock();
    private Condition isSpace = lock.newCondition();
    private Condition isEmpty = lock.newCondition();


    public void enque(Integer value) {
        lock.lock();
            while(size()==SIZE) try {isSpace.await();} catch (Exception e) {e.printStackTrace();}
        System.out.println("adding: " + value);
            q.add(0, value);
            isEmpty.signalAll();
        lock.unlock();
    }

    public Integer deque() {
        lock.lock();
            while(size()==0) try {isEmpty.await();} catch (Exception e) {e.printStackTrace();}
            Integer response = q.get(q.size() - 1);
            System.out.println("removing: " + response);
            q.remove(q.size() - 1);
            isSpace.signalAll();
        lock.unlock();
        return response;
    }

    public int size() {
        return q.size();
    }


    public static void main(String[] args) {
        BlockingQueue q = new BlockingQueue();
        Thread t1 = new Thread(() -> {for(int i = 0 ; i < 100 ; i++){
            q.enque(i);
           }});
        Thread t2 = new Thread(() -> {for(int i = 0 ; i < 100 ; i++){ q.deque();}});

        t1.start();
        t2.start();
    }
}