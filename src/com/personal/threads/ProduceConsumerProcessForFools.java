package com.personal.threads;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by pr250155 on 4/3/17.
 */
public class ProduceConsumerProcessForFools {
    public static void main(String[] args) {
        final BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1);
        new Thread(() -> {produce(blockingQueue);}).start();
        new Thread(() -> {consume(blockingQueue);}).start();

    }

    private static void consume(BlockingQueue<Integer> blockingQueue) {
        while(true){
            try {
                int item = blockingQueue.take();
                System.out.printf("\ntaking %d from the Queue",item);
                if(item == 99){
                    System.out.println("\nJob Completed");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void produce(BlockingQueue<Integer> blockingQueue) {
        int i = 0;
        while(i<100){
            System.out.printf("\nAdding %d to the Queue",i++);
            try {
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
