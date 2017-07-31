package com.personal;

import java.util.Arrays;

/**
 * Created by prajeeva on 7/29/17.
 */
public class MinDiffPair {
    public int findMinDiff(int[] targeet) {
        Arrays.sort(targeet);
        int max=Integer.MAX_VALUE;
        for(int i = 0 ; i < targeet.length - 1; i++) {
            max = Math.min(max , targeet[i+1]- targeet[i]);
        }
        return max;
    }
}
