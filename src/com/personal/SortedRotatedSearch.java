package com.personal;

/**
 * Created by prajeeva on 10/29/17.
 */
public class SortedRotatedSearch {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) {if(nums[0] == target) {return 0;} else {return -1;}}
        if(nums.length == 2) {
            if(nums[0] == target) return 0;
            if(nums[1] == target) return 1;
        }
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[low] < nums[high]) {
                //your still in the zone
                if(target > nums[mid]) low = mid+1;
                else if(target < nums[mid]) high = mid -1;
                else return mid;
            } else {
                //check if low to mid is sorted
                if(target == nums[mid]) return mid;
                if(nums[low] < nums[mid] && target >= nums[0] && target <= nums[mid]) {
                    high = mid - 1;
                } else if(nums[mid] < nums[high] && target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else if(nums[low] < nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
