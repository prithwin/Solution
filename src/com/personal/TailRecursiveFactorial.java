package com.personal;

/**
 * Created by prajeeva on 9/22/17.
 */
public class TailRecursiveFactorial {
    int fact(int n , int f) {
        if(n == 1) return f;
        f*=n;
        return fact(n-1 , f);
    }
    public static void main(String[] args) {
        System.out.println(new TailRecursiveFactorial().fact(5,1));
    }
}
