package com.random.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

class LambdasTest {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<String> outputBuffer = new LinkedList();
        for(int i = 0 ; i < N ; i++) {
            int length = scanner.nextInt();
            scanner.nextLine();
            String target = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for(char c : target.toCharArray()) {
                char cPrime = (char)getNearestPrimeAlphabet(c);
                if(cPrime<67) cPrime =67;
                if(cPrime>113)cPrime = 113;
                stringBuilder.append(cPrime+"");
            }
            outputBuffer.add(stringBuilder.toString());
        }
        outputBuffer.stream().forEach(System.out::println);
    }

    private static int getNearestPrimeAlphabet(int c){
        if(isPrime(c)) return c;
        int lowPrime = 0;
        int highPrime = 0;
        boolean foundLowPrime = false;
        boolean foundHighPrime = false;

        for(int i = c+1 , j = c-1 ; ;) {
            if(!foundLowPrime) {
                if(isPrime(j)) {
                    foundLowPrime = true;
                    lowPrime = j;
                }
                j--;
            }
            if(!foundHighPrime) {
                if(isPrime(i)) {
                    foundHighPrime = true;
                    highPrime = i;
                }
                i++;
            }
            if(foundLowPrime && foundHighPrime){
                break;
            }
        }
        int lowPrimeDiff = c - lowPrime;
        int highPrimeDiff = highPrime - c;
        if(lowPrimeDiff == highPrimeDiff) {
            return lowPrime;
        } else if(lowPrimeDiff<highPrimeDiff) {
            return lowPrime;
        } else if(lowPrimeDiff>highPrimeDiff) {
            return highPrime;
        }
        return c;
    }

    private static boolean isPrime(int c){
        int divisorCount = 0 ;
        for(int i = 1 ; i <=c ; i++) {
            if(c % i == 0 ){
                divisorCount++;
            }
        }
        if(divisorCount == 2){
            return true;
        }
        return false;
    }
}
