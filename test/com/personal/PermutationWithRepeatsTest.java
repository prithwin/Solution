package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/15/17.
 */
public class PermutationWithRepeatsTest {
    @Test
    public void testPermuteUnique() throws Exception {
        int[] target = {2,3,1,3,3};
        System.out.println(new PermutationWithRepeats().permuteUnique(target));
    }

}