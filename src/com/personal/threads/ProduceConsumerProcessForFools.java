package com.personal.threads;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by pr250155 on 4/3/17.
 */
public class ProduceConsumerProcessForFools {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<>(1);
        new Thread(() -> {
            for(int i= 0 ; i < 100 ; i++ )
                try {
                    System.out.println("adding:" + i);
                    q.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();

        new Thread(()-> {
            for(int i = 0 ; i < 100 ; i++) {
                try {
                    System.out.println("taking:" + q.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
