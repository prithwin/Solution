package com.personal;

import java.util.*;

/**
 * Created by prajeeva on 10/1/17.
 */
public class MaxSubarraySum {

    public int subarraySum(int[] nums, int k) {
       int sum = 0;
       int count = 0;
       Map<Integer , Integer> reg = new HashMap<>();
       for(int i = 0 ; i < nums.length ;i++) {
           reg.put(sum , reg.getOrDefault(sum,0)+1);
           sum+=nums[i];
           count += reg.getOrDefault(sum-k,0);
       }
       return count;
    }
}
