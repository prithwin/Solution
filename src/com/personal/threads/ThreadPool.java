package com.personal.threads;

import scala.Char;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 5/24/17.
 */
public class ThreadPool {

    private AtomicInteger c;
    private int maxPoolSize;
    BlockingQueue<Thread> taskQueue;

    public ThreadPool(int maxPoolSize) {
        c = new AtomicInteger(0);
        this.maxPoolSize = maxPoolSize;
        this.taskQueue = new LinkedBlockingQueue<>(maxPoolSize);
    }

//    private void startExecution() {
//        for(;;) {
//            Runnable task =
//        }
//    }

    public void execute(Runnable task) {

    }

    public static void main(String[] args) {

    }

    boolean isCryptSolution(String[] crypt, char[][] solution) {
        Map<Character, Integer> reg = getMap(solution);
        int a = findSum(crypt[0],reg);
        int b = findSum(crypt[1],reg);
        int c = findSum(crypt[2],reg);
        System.out.println(String.format("a=%d b=%d c=%d",a,b,c));
        return a+b == c || b+c == a || c+a == b;
    }

    private int findSum(String s , Map<Character, Integer> reg) {
        StringBuilder number = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++) {
            number.append(s.charAt(i));
        }
        return Integer.parseInt(number.toString());
    }

    private Map<Character,Integer> getMap(char[][] solution) {
        Map<Character,Integer> response = new HashMap<>();
        for(int i = 0 ; i < solution.length ; i++) {
            response.put(solution[i][0] , solution[i][1] - 0);
        }
        return response;
    }

}
