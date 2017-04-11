package com.personal.threads;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by prajeev
 */
public class ThreeThreadTurnBased {
    public static void main(String[] args) throws InterruptedException {
        NoticeBoard noticeBoard = new NoticeBoard();
        noticeBoard.turn = 1;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 1; i < 4; i++) {
            Runner runner = new Runner(i, noticeBoard,latch);
            executorService.execute(runner);
        }
        latch.countDown();
        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        executorService.shutdown();
    }

    static class NoticeBoard {
        volatile int turn;

        Lock noticeBoardLock = new ReentrantLock();
        Condition condition = noticeBoardLock.newCondition();

        public void printNumber(int number, int seed) throws InterruptedException {
            noticeBoardLock.lock();
            while (turn != seed)
                condition.await();
            System.out.println("[" + seed + "]" + number);
            if (++turn == 4) {
                turn = 1;
            }
            condition.signalAll();
            noticeBoardLock.unlock();
        }
    }

    static class Runner implements Runnable {

        private final CountDownLatch latch;
        int seed;
        NoticeBoard noticeBoard;

        public Runner(int i, NoticeBoard noticeBoard, CountDownLatch latch) {
            this.seed = i;
            this.noticeBoard = noticeBoard;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int count = 0;
            for (int i = seed; count < 2; i += 3, count++) {
                try {
                    noticeBoard.printNumber(i, seed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


