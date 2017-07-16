package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/14/17.
 */
public class NumberOfDistinctSubsequenceTest {
    @Test
    public void testNumDistinct() throws Exception {
        System.out.println(new NumberOfDistinctSubsequence().numDistinctBf("rabbbbbit","rabbit"));
    }

}