package com.personal.threads;

/**
 * Created by prajeev on 4/1/17.
 */
public class InfiLoopz {
    public static void main(String[] args) throws InterruptedException {
        NoticeBoard noticeBoard = new NoticeBoard();
        noticeBoard.turn = 1;
        Runner runner1 = new Runner(1,noticeBoard);
        Runner runner2 = new Runner(2,noticeBoard);
        Runner runner3 = new Runner(3,noticeBoard);
        Thread t1 = new Thread(runner1);
        Thread t2 = new Thread(runner2);
        Thread t3 = new Thread(runner3);
        t2.start();
        t1.start();
        t3.start();
    }
}

class NoticeBoard {
    int turn;
    private final Object lock = new Object();
    public void printNumber(int number,int seed) throws InterruptedException {
        synchronized (lock) {
            //wait for my turn
            while (turn != seed) {
                lock.wait();
            }
            System.out.println("[" + seed + "]" + number);
            turn++;
            if (turn == 4) {
                turn = 1;
            }
            lock.notifyAll();
        }

    }
}

class Runner implements Runnable{

    int seed;
    NoticeBoard noticeBoard;

    public Runner(int i, NoticeBoard noticeBoard) {
        this.seed = i;
        this.noticeBoard = noticeBoard;
    }

    @Override
    public void run() {
        int count = 0;
        for(int i = seed ; count < 10 ; i+=3, count++){
            try {
                noticeBoard.printNumber(i,seed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
