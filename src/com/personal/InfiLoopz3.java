package com.personal;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by prajeev on 1/3/17.
 */

//infiloopz inmplementation using Cyclic barrier
public class InfiLoopz3 {
    public static void main(String[] args) throws InterruptedException {
        final NoticeBoard noticeBoard = new NoticeBoard();
        noticeBoard.turn=1;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {

            @Override
            public void run() {
                System.out.println("everyone waiting");
               noticeBoard.turn = noticeBoard.turn+1;
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 4; i++) {
            Runner runner = new Runner(i, noticeBoard,cyclicBarrier);
            executorService.execute(runner);
        }
    }

    static class NoticeBoard {
        volatile int turn;
    }

    static class Runner implements Runnable {

        private final CyclicBarrier cyclicBarrier;
        private final NoticeBoard noticeBoard;
        int seed;

        public Runner(int i, NoticeBoard noticeBoard, CyclicBarrier cyclicBarrier) {
            this.seed = i;
            this.noticeBoard = noticeBoard;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            int count = 0;
            for (int i = seed; count < 10; i += 3, count++) {
                try {
                    try {
                        cyclicBarrier.await();
                        while (noticeBoard.turn!=seed) {
                        }
                        System.out.println("[" + seed + "]" + i);
                        cyclicBarrier.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }

            }
        }
    }
}


