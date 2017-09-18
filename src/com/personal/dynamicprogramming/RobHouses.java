package com.personal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prajeeva on 9/17/17.
 */
public class RobHouses {
     public int rob(int[] nums) {
         if(nums.length == 0) return 0;
         if(nums.length == 1) return nums[0];
         if(nums.length == 2) return Math.max(nums[0] , nums[1]);
         return Math.max(nums[0] + rob(Arrays.copyOfRange(nums, 2,nums.length)) ,rob(Arrays.copyOfRange(nums, 1,nums.length)) );
     }

    public int robdp(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        res.add(Math.max(nums[0],nums[1]));
        for(int i = 2 ; i < nums.length ; i++) {
            res.add(Math.max(nums[i] +res.get(i-2) , res.get(i-1)));
        }
        return res.get(nums.length -1);
    }
}
