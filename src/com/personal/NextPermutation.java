package com.personal;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajeeva on 7/15/17.
 *
 * 8 7 6 5 4 3 2 1
 *
 * 4 3 2 1
 * [1, 2, 3, 4, 7, 8, 6, 5], [1, 2, 3, 4, 8, 5, 6, 7]
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int rp = 0;
        for(int i = nums.length - 1 ; i >=0 ; i--) {
            if(nums[i-1] < nums[i]) {
                rp = i ;
                int pivot =  i - 1;
                for(int j = nums.length - 1 ; j <=pivot ; j--) {
                    if(nums[j] >= nums[pivot]) {
                        int temp = nums[pivot];
                        nums[pivot] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                break;
            }
        }
        for(int i = rp , j = nums.length - 1 ; i < j ; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
