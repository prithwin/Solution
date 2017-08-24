package com.personal;

import java.util.Arrays;

/**
 * Created by prajeeva on 8/4/17.
 */
public class RemoveDuplicatesFromArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
       return removeDuplicatesInternal(nums, 1);
    }

    private int removeDuplicatesInternal(int[] nums , int start) {
        if(nums.length - 1 - start < 2) return nums.length - start + 1;
        if(nums[start] != nums[start - 1]) {
            return 1 + removeDuplicatesInternal(nums , ++start);
        } else {
            return  removeDuplicatesInternal(nums , ++start);
        }
    }
}
