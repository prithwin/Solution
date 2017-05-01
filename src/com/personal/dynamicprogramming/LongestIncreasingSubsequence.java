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
    class Answer {
        int length;
        List<Integer> longestIncreasingSubsequence;
    }
    public Answer findLongestIncreasingSubsequnce(List<Integer> target) {
        int[] results = new int[target.size()];
        for(int k = 0 ; k < results.length ; k++) {
            results[k] = 1;
        }
        for(int i = 1 ; i < target.size() ; i++) {
            for(int j = 0 ; j < i ;j++) {
                if(target.get(j) < target.get(i)){
                    results[i] = Mathematical.maximum(results[i],1 + results[j]);
                } else {
                    results[i] = 1;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new LongestIncreasingSubsequence().findLongestIncreasingSubsequnce(Arrays.asList(10,22,9,33,21,50,41,60,80));
    }
}
