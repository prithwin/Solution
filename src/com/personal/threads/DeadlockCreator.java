package com.personal.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by prajeev on 14/3/17.
 */
public class DeadlockCreator {

      static class NoticBoard {
          Chalk chalk;
          public synchronized void writeOnBoard(String content){
              chalk.getNewChalk("white");
              System.out.println("writeing on noticBoard:"+ content);
              if(!content.contains("B"))
                chalk.replaceChalk();
          }
      }

    static class Chalk {
        int availablePcs = 1;
        public synchronized Chalk getNewChalk( String color) {
            while(availablePcs ==0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            availablePcs--;
            System.out.println("creating new "+color+" piece of chalk");
            return new Chalk();
        }

        public synchronized void replaceChalk(){
            availablePcs++;
        }
    }

    public static void main(String[] args) {
        NoticBoard nb = new NoticBoard();

        Chalk chalk = new Chalk();
        nb.chalk = chalk;
        new Thread(() -> {
            nb.writeOnBoard("ThreadA content");
        }).start();
        new Thread(() -> {
            nb.writeOnBoard("ThreadB content");
        }).start();
        AtomicLong atomicLong = new AtomicLong();
//        atomicLong.compareAndSet()
    }
}
