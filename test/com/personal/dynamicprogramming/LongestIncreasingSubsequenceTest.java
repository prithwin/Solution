package com.personal.dynamicprogramming;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 6/30/17.
 */
public class LongestIncreasingSubsequenceTest {
    @Test
    public void testFindLISm() throws Exception {
        int[] target = {10,22,9,45,3,7,55,80};
        assertEquals(new LongestIncreasingSubsequence().findLIS(target),5);
    }

    @Test
    public void testFindLIS() throws Exception {
        int[] target = {10,22,9,45,3,7,55,80};
        assertEquals(new LongestIncreasingSubsequence().findLISm(target),5);
    }

}