package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/13/17.
 */
public class MedianOfTwoSortedArraysTest {
    @Test
    public void testFindMedianSortedArrays() throws Exception {
        int[] thz = {1,2};
        int[] tht = {3,4};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(thz,tht));
    }

}