package com.personal;

/**
 * Created by prajeev on 9/3/17.
 */
public class Fibonacci {

    public void printFibonacciNumbers(int iterations){
        int m=0;
        int n=1;
        System.out.println(n);
        for(int i = 0; i< iterations ;i++){
            int sum = m+n;
            System.out.println(sum);
            m=n;
            n=sum;
        }

    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.printFibonacciNumbers(11);
         f.fibonacciRecursive(11);
    }

    public void fibonacciRecursive(int howMany){
        fibonacciRecursiveInternal(0,1,howMany,0);
    }

    private void fibonacciRecursiveInternal(int m, int n ,int howMany, int counter) {
        if(counter == howMany){
            return;
        }else {
           // System.out.println(m);
            System.out.println(n);
            fibonacciRecursiveInternal(n, m + n, howMany, ++counter);
        }
    }
}
