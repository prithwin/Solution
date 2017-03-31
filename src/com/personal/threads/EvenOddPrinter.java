package com.personal.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 3/31/17.
 */
public class EvenOddPrinter {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition evenPrint = lock.newCondition();
        Condition oddPrint = lock.newCondition();
        BooleanNoticeBord noticeBord = new BooleanNoticeBord(false);
        Thread t1 = new Thread(new EvenPrinter(lock,noticeBord,evenPrint,oddPrint));
        Thread t2 = new Thread(new OddPrinter(lock,noticeBord,evenPrint,oddPrint));
        t1.start();
        t2.start();
    }
}


class BooleanNoticeBord {

    BooleanNoticeBord(boolean even){
        this.even=even;
    }

    boolean even = true;
}
class EvenPrinter implements Runnable {
    Lock lock;
    BooleanNoticeBord board;
    Condition evenPrint;
    Condition oddPrint;

    EvenPrinter(Lock lock, BooleanNoticeBord noticeBord, Condition evenprint,Condition oddPrint){
        this.lock = lock;
        this.board = noticeBord;
        this.evenPrint=evenprint;
        this.oddPrint=oddPrint;
    }

    @Override
    public void run() {

        for(int i=1;i<100;i++){
            if(i%2==0){
                lock.lock();
                while(!board.even){
                    try {
                        evenPrint.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("EvenPrinter: "+i);
                board.even = !board.even;
                oddPrint.signal();
                lock.unlock();
            }
        }
    }
}

class OddPrinter implements Runnable {
    Lock lock;
    BooleanNoticeBord board;
    Condition evenPrint;
    Condition oddPrint;

    OddPrinter(Lock lock, BooleanNoticeBord noticeBord, Condition evenprint,Condition oddPrint){
        this.lock = lock;
        this.board = noticeBord;
        this.evenPrint=evenprint;
        this.oddPrint=oddPrint;
    }
    @Override
    public void run() {
        for(int i=1;i<100;i++){
            if(i%2!=0){
                lock.lock();
                while (board.even){
                    try {
                        oddPrint.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("OddPrinter: "+i);
                board.even = !board.even;
                evenPrint.signal();
                lock.unlock();
            }
        }
    }
}