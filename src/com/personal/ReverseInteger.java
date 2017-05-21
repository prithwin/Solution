package com.personal;

/**
 * Created by pr250155 on 2/17/16.
 */
public class ReverseInteger {
   public int reverse(int target) {
       int mul=1;
       if(target<0) {
           target = Math.abs(target);
           mul = -1;
       }
       int result = 0 ;
       int n = Integer.MAX_VALUE;
       int resultRadix = 1;
       int temp = 0;
       while(temp != target){
           resultRadix *=10;
           temp = target % resultRadix;
       }
       resultRadix/=10;
       int modRadix = 10;
       int divRadix = 1;
       while(n > 0){
           n = (target % modRadix) / divRadix;
           result = result + (resultRadix * n);
           modRadix*=10;
           divRadix*=10;
           resultRadix/=10;
       }
       return mul*result;

   }
}
