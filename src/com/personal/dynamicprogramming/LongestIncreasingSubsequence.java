package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;

import java.util.*;

/**
 * Created by pr250155 on 4/30/17.
 *
 *      10  22  9  33  21  50  41  60  80
 *       1   1   1   1   1   1   1   1   1
 */
public class LongestIncreasingSubsequence {

    public int findLISm(int[] target) {
        int[] result = new int[target.length];
        for(int i = 0 ; i < target.length ; i++) {
            //initialize the array to one
            result[i] = 1;
        }

        for(int i = 1 ; i < target.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(target[i] > target[j]) {
                    result[i] = Mathematical.maximum(result[i] ,1 + result[j]);
                }
            }
        }
        return result[target.length - 1] ;

    }


    //recursive implementation for the longest recursive subsequence problem.
    public int findLIS(int[] target) {
        if(target.length == 0) return 0;
        if(target.length == 1) return 1;
        int max = Integer.MIN_VALUE;
        int frame;
        for(int i = 1 ; i < target.length ; i++) {
            if(target[i] > target[0]) {
                frame = 1 +  findLIS(Arrays.copyOfRange(target,i,target.length) );
                if(frame > max){
                    max = frame;
                }
            }
        }
        return max;
    }
}
