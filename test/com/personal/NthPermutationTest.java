package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 8/2/17.
 */
public class NthPermutationTest {
    @Test
    public void testGetPermutation() throws Exception {
        System.out.println(new NthPermutation().getPermutation(3,4));
    }

}