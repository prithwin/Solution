package com.functional;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

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