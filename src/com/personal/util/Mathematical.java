package com.personal.util;

import java.util.ArrayList;
import java.util.List;

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
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n%2 == 0) return power(x,n/2) * power(x,n/2);
        else {
            return power(x,n/2) * power(x ,n/2+n%2);
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

    public static List<Integer> getBinaryRepresentationAsAList(int number,int setSize) {
        List<Integer> responseList = new ArrayList<>();
        getBinaryRepresentationAsAListInternal(number,responseList);
        if(responseList.size()<setSize) {
            int diff = setSize - responseList.size();
            while (diff>0){
                responseList.add(0,0); diff--;
            }
        }
        return responseList;
    }

    private static void getBinaryRepresentationAsAListInternal(int number, List<Integer> responseList) {
        if (number <= 1){
            responseList.add(number);
        } else {
            getBinaryRepresentationAsAListInternal(number / 2 , responseList);
            getBinaryRepresentationAsAListInternal(number % 2 , responseList );
        }
    }

    public static int min(int thiz, int that) {
        if (thiz <= that)
            return thiz;
        return that;
    }

    public int findComplement(int num) {
        String rep = Integer.toBinaryString(num);
        String com = "";
        for(int i = 0 ; i < rep.length() ; i++) {
            if(rep.charAt(i) == '1') {
                com = "0" + com;
            } else {
                com = "1" + com;
            }
        }
        return Integer.parseInt(com,2);
    }

}
