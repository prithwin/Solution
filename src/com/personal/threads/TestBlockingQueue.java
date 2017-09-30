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
            queue.enque(i);
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
                System.out.println("removing element"+ queue.deque());

        }
    }
}
