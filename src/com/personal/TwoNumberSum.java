package com.personal;

import java.util.*;

/**
 * Created by pr250155 on 1/19/16.
 * these are purely superficial comments that are added just to test my workspace
 */
public class TwoNumberSum {
    public List<Integer> twoSum(int[] nums, int target) {
        //scan and store the indices in a map:
        Map<Integer,Integer> storage = new HashMap<Integer,Integer>((int)(nums.length/0.75)+1);
        for(int i=0 ;i<nums.length; i++){
            storage.putIfAbsent(nums[i],i);
            int temp = target-nums[i];
            if(i>0 && storage.containsKey(temp)){
                //such a combination is found
                int a = storage.get(temp)+1;
                int b = i+1;
                if(a!=b) {
                    List<Integer> result = new ArrayList<>();
                    result.add(a);
                    result.add(b);
                    return result;
                }
            }
        }
        return null;
    }

}
