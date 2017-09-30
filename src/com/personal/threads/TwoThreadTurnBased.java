package com.personal.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by prajeeva on 9/18/17.
 */
public class TwoThreadTurnBased {
    private static class NoticeBoard {
        private boolean even;
        private Lock lock;
        private Condition condition;

        public void freeze(boolean even) {
            lock.lock();
            while(this.even!=even) try {
                condition.await();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void unfreeze() {
            even = !even;
            condition.signalAll();
            lock.unlock();
        }
        public NoticeBoard(boolean even) {
            this.even = even;
            lock = new ReentrantLock();
            condition = lock.newCondition();
        }

    }

    private static class Runner implements Runnable {
        private boolean even;
        private NoticeBoard noticeBoard;
        private CountDownLatch latch;


        public Runner(boolean even, NoticeBoard noticeBoard,CountDownLatch latch) {
            this.even = even;
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
            if(even) {
                for(int i = 2 ; i < 100 ; i+=2) {
                   // noticeBoard.freeze(even);
                    System.out.printf("[even]%d\n",i);
                  //  noticeBoard.unfreeze();
                }
            } else {
                for(int i = 1 ; i < 100 ; i+=2) {
                 //   noticeBoard.freeze(even);
                    System.out.printf("[odd]%d\n",i);
                  //  noticeBoard.unfreeze();
                }
            }
        }
    }

    public static void main(String[] args) {
        NoticeBoard nb = new NoticeBoard(false);
        CountDownLatch latch = new CountDownLatch(1);
        Thread t1 = new Thread(new Runner(false, nb,latch));
        Thread t2 = new Thread(new Runner(true, nb,latch));
        t1.start();
        t2.start();
        latch.countDown();
    }
}
