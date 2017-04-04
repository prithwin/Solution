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
            new Thread(() -> {waitedPrint(semaphore,workingList);}).start();
        }
    }

    private static void waitedPrint(Semaphore semaphore, List<Integer> workingList) {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            workingList.parallelStream().
                    filter((e) -> e+5==10).
                    map((e) -> e*=2).
                    forEach(System.out::print);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
