package com.personal;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajeeva on 7/15/17.
 *
 * 8 7 6 5 4 3 2 1
 *
 * 4 3 2 1
 * [1, 2, 3, 4, 7, 8, 6, 5], [1, 2, 3, 4, 8, 5, 6, 7]
 */
public class NextPermutation {

    public void nextPermutation(int[] num) {

        if(num.length < 2) {
            return;
        }

        int ip = num.length - 1;

        while(ip > 0) {
            if(num[ip-1] < num[ip]) break;
            ip--;
        }

        if(ip == 0) {
            reverse(num , 0 , num.length - 1);
            return;
        }
        int sp = num.length - 1;
        while(sp >= ip) {
            if(num[sp] > num[ip - 1]) break;
            sp--;
        }
        int temp = num[ip - 1];
        num[ip - 1] = num[sp];
        num[sp] = temp;
        reverse(num, ip,num.length - 1);

    }

    private void reverse(int[] num , int start , int end) {
        while(start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;end--;
        }
    }
}
