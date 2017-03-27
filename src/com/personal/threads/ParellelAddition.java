package com.personal.threads;

import java.util.concurrent.*;

/**
 * Created by pr250155 on 3/27/17.
 */
public class ParellelAddition {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Future<Integer> resultone = executorService.submit(new AdderThread(7, 9, countDownLatch));
        Future<Integer> resultTwo = executorService.submit(new AdderThread(13, 16, countDownLatch));
        countDownLatch.countDown();
        Future<Integer> resutThree = executorService.submit(new AdderThread(resultone.get(), resultTwo.get(), countDownLatch));
        System.out.println(resutThree.get());
    }

}

class AdderThread implements Callable<Integer>{
    int a;
    int b;
    CountDownLatch countDownLatch;

    AdderThread(int a, int b, CountDownLatch countDownLatch){
        this.a = a;
        this.b = b;
        this.countDownLatch = countDownLatch;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        countDownLatch.await();
        Integer result = a+b;
        return result;
    }
}