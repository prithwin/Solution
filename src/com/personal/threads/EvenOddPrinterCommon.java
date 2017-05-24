package com.personal.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 5/23/17.
 */
public class EvenOddPrinterCommon {
    static class NoticeBoard {
        boolean even;
        Lock noticeBoardLock = new ReentrantLock();
        Condition condition = noticeBoardLock.newCondition();

        public void print(int num) throws InterruptedException {
            noticeBoardLock.lock();
            if(num % 2 == 0) {
                while(!even){
                    condition.await();
                }
            } else {
                while(even){
                    condition.await();
                }
            }
            System.out.println(num);
            even = !even;
            condition.signal();
            noticeBoardLock.unlock();
        }
    }

    static class PrintRunner implements Runnable {

        NoticeBoard noticeBoard;
        int start;

        public PrintRunner(NoticeBoard noticeBoard,int start) {
            this.noticeBoard = noticeBoard;
            this.start = start;
        }

        @Override
        public void run() {
            for(int i = start ; i < 20 ; i+=2) {
                try {
                    noticeBoard.print(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        NoticeBoard noticeBoard = new NoticeBoard();
        noticeBoard.even = false;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new PrintRunner(noticeBoard,1));
        executorService.execute(new PrintRunner(noticeBoard,2));

    }
}

