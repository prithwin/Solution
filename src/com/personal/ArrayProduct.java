package com.personal;

/**
 * Created by prajeev on 20/3/17.
 * basic logic: start with basic list 1,2,3,4
 * 1 -> 1,0,0,0
 * 1*1 -> 1,1,0,0
 * 1*1*2 -> 1,1,2,0
 * 1*1*2*3 -> 1,1,2,6
 *
 * you have made sure that for each element i has the product of all the elements towards the left of it.
 * now this product need to have the product of every element to the right of it
 *
 * 1,1,2,6 <- 1
 * 1,1,8,6 <- 1*4
 * 1,12,8,6 <- 1*4*3
 * 24,12,8,6 <- 1*4*3*2
 *
 */
public class ArrayProduct {

    public int[] computeProductArrayShort(int[] nums) {
        int[] result = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = temp;
            temp = temp*nums[i];
        }
        temp = 1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            result[i] *= temp;
            temp = temp*nums[i];
        }
        return result;
    }
}
