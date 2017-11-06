package com.random.test.old;

import com.personal.threads.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Z {

    public static int seed = 1;

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(4);
        executor.execute(() -> {
            System.out.println("Some of the thing s are good ");
        });
    }

}
