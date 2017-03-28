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

    private List<Integer> whatLiesWithin = new ArrayList<Integer>(56);
    Lock queueLock = new ReentrantLock();
    Condition conditionFull = queueLock.newCondition();


    private int THEORITICAL_MAX = 3;

    public Integer remove() throws InterruptedException {
        queueLock.lock();
        Integer returnValue = 0;
        while (whatLiesWithin.size()<1){
            conditionFull.await();
        }
        returnValue = whatLiesWithin.get(0);
        whatLiesWithin.remove(0);
        conditionFull.signalAll();
        queueLock.unlock();
        return returnValue;
    }

    public void add(Integer value) throws InterruptedException {
        queueLock.lock();
        while (whatLiesWithin.size()>=THEORITICAL_MAX) {
            conditionFull.await();
        }
        whatLiesWithin.add(value);
        conditionFull.signalAll();
        queueLock.unlock();
    }
}
