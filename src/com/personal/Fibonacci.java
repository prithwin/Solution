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
    }
}
