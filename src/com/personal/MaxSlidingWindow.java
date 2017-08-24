package com.personal;

import java.util.*;

/**
 * Created by prajeeva on 8/6/17.
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 )return new int[0];
        List<Integer> response = new ArrayList<>();
        for(int i = 0 ; i <= nums.length - k  ; i++) {
            response.add(findMax(Arrays.copyOfRange(nums,i,i + k)));
        }
        int[] ans = new int[response.size()];
        for(int i = 0 ; i < ans.length ; i++) {
            ans[i] = response.get(i);
        }
        return ans;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            max = Math.max(max , i );
        }
        return max;
    }
}
