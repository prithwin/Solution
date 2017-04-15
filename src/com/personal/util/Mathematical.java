package com.personal.util;

/**
 * Created by pr250155 on 3/27/17.
 */
public class Mathematical {
    public static int factorial(int n){
        return factorialInner(n,1);
    }

    private static int factorialInner(int upper, int lower) {
        if(upper==lower){
            return upper;
        }
        if(lower>upper){
            return 1;
        }

        return factorialInner(upper,((upper+lower)/2)+1)*factorialInner(((upper+lower)/2),lower);
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n%2==0){
            //even power
            return power(x,n/2)*power(x,n/2);
        } else {
            return power(x,(n/2))*power(x,(n/2)+1);
        }
    }

    public static int maximum(int thizz, int that) {
        if(thizz > that){
            return thizz;
        } else {
            return that;
        }
    }

    public static void decimalTobinary(int decimal){
         if(decimal<2){
             System.out.print(decimal);
         } else{
             decimalTobinary(decimal / 2);
             decimalTobinary(decimal % 2);
         }
    }

    public static int gcd(int m, int n) {
        if(n == 0){
            return m;
        } else {
            return gcd(n, m % n);
        }
    }
}
