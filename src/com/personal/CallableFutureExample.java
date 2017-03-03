package com.personal;

import java.util.concurrent.*;

/**
 * Created by prajeev on 1/3/17.
 */
public class CallableFutureExample {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> handleWhenCompleted = executorService.submit(new CallableClass());
        System.out.println("i'll be first");
        try {
            while(!handleWhenCompleted.isDone()){
                System.out.println("I am still working");
            }
            int computedValue = handleWhenCompleted.get();
            System.out.println(computedValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return;
    }
    static class CallableClass implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            //Thread.sleep(1000);
            return 500;
        }
    }
}
