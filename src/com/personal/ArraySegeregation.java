package com.personal;

/**
 * seggregate and array and bring all the zeroes on one side.
 */
public class ArraySegeregation {

    public void moveZeroes(int[] nums) {
        move(nums, nums.length);
    }

    private void move(int[] nums , int limit) {
        if (limit == 0) return;
        for (int i = 1; i < limit; i++) {
            if (nums[i - 1] == 0) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
        move(nums, limit - 1);
    }

    public void moveZeroesO(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
