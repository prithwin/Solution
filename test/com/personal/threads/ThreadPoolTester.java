package com.personal.threads;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import java.util.*;

/**
 * Created by pr250155 on 5/24/17.
 */
public class ThreadPoolTester {
    @Test
    public void testThreadPool() throws InterruptedException {
        ThreadPool pool = new ThreadPool(3);
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new IndexedRunner(i));
            pool.execute(thread);
        }
    }

    static class IndexedRunner implements Runnable {
        int index;

        IndexedRunner(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("running Thread " + index);
            try {
                Thread.sleep((index%4)* 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}
