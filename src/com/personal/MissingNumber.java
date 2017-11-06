package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prajeeva on 10/28/17.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int ts = ((nums.length * (nums.length - 1)) / 2);
        return ts - Arrays.stream(nums).reduce((a,b) -> a+b).getAsInt();
    }
}
