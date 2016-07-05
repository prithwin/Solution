package com.personal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 1/19/16.
 * these are purely superficial comments that are added just to test my workspace
 */
public class TwoNumberSum {
    public int[] twoSum(int[] nums, int target) {
        //scan and store the indices in a map:
        Map<Integer,Integer> storage = new HashMap<Integer,Integer>((int)(nums.length/0.75)+1);
        int[] returner = new int[2];
        for(int i=0 ;i<nums.length; i++){
            storage.putIfAbsent(nums[i],i);
            int temp = target-nums[i];
            if(i>0 && storage.containsKey(temp)){
                //such a combination is found
                int a = storage.get(temp)+1;
                int b = i+1;
                if(a!=b) {
                    returner[0]=a;
                    returner[1]=b;
                    return returner;
                }
            }
        }
        return null;
    }

}
