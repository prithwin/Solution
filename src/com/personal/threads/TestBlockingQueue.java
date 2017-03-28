package com.personal.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by prajeev on 2/3/17.
 */
public class TestBlockingQueue {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        BlockingQueue integerQueue = new BlockingQueue();
        ProducerProcess2 producerProcess = new ProducerProcess2(integerQueue);
        ConsumerProcess2 consumerProcess = new ConsumerProcess2(integerQueue);
        service.execute(producerProcess);
        service.execute(consumerProcess);
    }
}

class ProducerProcess2 implements Runnable{


    private final BlockingQueue queue;

    public ProducerProcess2(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 150;i++) {
            try {
                System.out.println("adding element"+i);
                queue.add(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }

}

class ConsumerProcess2 implements Runnable{

    private final BlockingQueue queue;

    public ConsumerProcess2(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true){
            try {
                System.out.println("removing element"+ queue.remove());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
