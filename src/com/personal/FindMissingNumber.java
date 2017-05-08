package com.personal;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/18/17.
 */
public class FindMissingNumber {
    public int findMissingNumber(List<Integer> target){
        int n = target.size()+1;
        int theoreticalSum = (n * (n+1))/2;
        int actualSum = target.parallelStream().reduce((a,b) -> a+b).get();
        return theoreticalSum - actualSum;
    }
}
