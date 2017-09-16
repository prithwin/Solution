package com.personal;


import java.util.Map;
import java.util.HashMap;
/**
 * Created by prajeeva on 9/15/17.
 */
public class FindPairs {
    public int findPairs(int[] nums, int k) {
        if(nums == null || k < 0) return 0;
        Map<Integer , Integer> reg = new HashMap<>();
        for(int i : nums) {
            reg.put(i , reg.getOrDefault(i,0) + 1);
        }
        int count = 0 ;
        for(Integer n : reg.keySet()) {

            if(k == 0) {
                if(reg.get(n) >= 2) count++;
            }else {
                if(reg.containsKey(n + k)) count++;
            }


        }
        return count;
    }
}
