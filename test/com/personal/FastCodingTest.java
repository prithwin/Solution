package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/25/17.
 */
public class FastCodingTest {

    @Test public void isPallindrome() {
        assertTrue(isPal("ABBA"));
        assertTrue(isPal("ABA"));
        assertFalse(isPal("ABsdfsdjf"));
    }

    @Test public void testFib() {
        int m = 0;
        int n = 1;
        System.out.println(1);
        for(int i = 0 ; i < 10 ; i++) {
            int sum = m+n;
            System.out.println(sum);
            m = n;
            n = sum;
        }
     }

     @Test public void bintest() {
        bin(1);
         System.out.println();
        bin(2);System.out.println();
        bin(3);System.out.println();
        bin(4);System.out.println();
        bin(5);System.out.println();
        bin(6);System.out.println();
        bin(7);System.out.println();
     }

     @Test public void towers() {
        towers("A","B","C",5);
     }

     private void towers(String source , String temp , String dest , int n) {
        if(n == 1) System.out.println(String.format("%s -> %s",source,dest));
        else {
            towers(source , dest , temp , n -1);
            System.out.println(String.format("%s -> %s",source,dest));
            towers(temp , source , dest , n -1);
        }
     }

     private void bin(int n) {
        if(n < 2) System.out.print(n);
        else {
            bin(n / 2);
            bin(n % 2);
        }
     }



   private boolean isPal(String s) {
        if(s.length() <=1) return true;
        else if(s.charAt(0) == s.charAt(s.length()-1) && isPal(s.substring(1, s.length()-1))) return true;
        return false;
   }

}
