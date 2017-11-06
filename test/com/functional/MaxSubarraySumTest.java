package com.functional;

import com.personal.MaxSubarraySum;
import org.testng.annotations.Test;

/**
 * Created by prajeeva on 10/1/17.
 */
public class MaxSubarraySumTest {
    @Test
    public void testSubarraySum() throws Exception {
        System.out.println(new MaxSubarraySum()
                .subarraySum(new int[]{1} , 0));
    }

}