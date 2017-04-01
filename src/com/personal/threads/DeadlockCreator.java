package com.personal.threads;

/**
 * Created by prajeev on 14/3/17.
 */
public class DeadlockCreator {


  static class Producer implements Runnable {

      SharedResource resource;

      @Override
      public void run() {
          resource.work("A");
      }
  }

    static class Consumer implements Runnable {
        SharedResource resource;

        @Override
        public void run() {
            resource.work("B");

        }
    }

    static  class SharedResource {
        public synchronized void work(String worker){
            System.out.println("Worker: "+worker);
        }
    }


  public static void main(String[] args){
      SharedResource object = new SharedResource();
      Producer producer = new Producer();
      Consumer consumer = new Consumer();
      producer.resource = object;
      consumer.resource = object;
      new Thread(producer).start();
      new Thread(consumer).start();

  }
}
