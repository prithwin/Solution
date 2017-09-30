package com.personal.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by pr250155 on 4/4/17.
 * makes tree threads work at a time for printing printing a list
 */
public class SemaphoreNThreads {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(3);
        final List<Integer> workingList = Arrays.asList(1,2,3,4,5,6);
        for(int i = 0 ; i < 10 ; i++ ){
            int tid = i;
            new Thread(() -> {waitedPrint(tid,semaphore);}).start();
        }
    }

    private static void waitedPrint(int processnumber,Semaphore semaphore) {
        try {
            semaphore.acquire();
            System.out.println(processnumber);
            Thread.sleep(1000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
