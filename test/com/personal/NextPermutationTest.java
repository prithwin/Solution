package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/15/17.
 */
public class NextPermutationTest {
    @Test
    public void testNextPermutation() throws Exception {
//        int[] target = {2,3,1,3,3};
        int[] target = {1,5,8,4,7,6,5,3,1};
        new NextPermutation().nextPermutation(target);
        for(int i = 0 ; i < target.length ; i++) {
            System.out.println(target[i]);
        }
    }

}