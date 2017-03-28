package com.personal.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by prajeev on 2/3/17.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Integer> integerQueue = new ArrayList<Integer>();
        Lock lock = new ReentrantLock();
        ProducerProcess producerProcess = new ProducerProcess(integerQueue,lock);
        ConsumerProcess consumerProcess = new ConsumerProcess(integerQueue,lock);
        service.execute(producerProcess);
        service.execute(consumerProcess);
    }
}

class ProducerProcess implements Runnable{


    private final List<Integer> integerQueue;
    private final Lock lock;

    public ProducerProcess(List<Integer> integerQueue, Lock lock) {
        this.integerQueue = integerQueue;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 150;) {
            lock.lock();
            if(integerQueue.size() <5 ) {
                System.out.println("queue has space so adding "+i);
                integerQueue.add(i);
                i++;
            }
            lock.unlock();
        }
    }
}

class ConsumerProcess implements Runnable{

    private final List<Integer> integerQueue;
    private final Lock lock;

    public ConsumerProcess(List<Integer> integerQueue, Lock lock) {
        this.integerQueue = integerQueue;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true) {
            lock.lock();
            Integer removed = 0 ;
            if(integerQueue.size() > 0){

                System.out.println("Queue has stuff so removing "+integerQueue.get(integerQueue.size()-1));
                removed = integerQueue.get(integerQueue.size()-1);
                integerQueue.remove(integerQueue.size()-1);

            }
            if(removed ==149){
                lock.unlock();
                break;
            }
            lock.unlock();

        }
    }
}
