package com.personal;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by prajeeva on 10/28/17.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] response = new int[2];
        Map<Integer ,Integer> reg = new HashMap<>();
        IntStream.range(0, nums.length).forEach(i -> reg.put(nums[i] , i ));
        IntStream.range(0 , nums.length).filter(i -> reg.containsKey(target - nums[i])).forEach(i -> {
            response[0] = i;
            response[1] = reg.get(i);
        });
        return response;
    }
}
