package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/29/17.
 */
public class MinDiffPairTest {
    @Test
    public void testFindMinDiff() throws Exception {
        int[] target = {1, 5, 3, 19, 18, 25};
        System.out.println(new MinDiffPair().findMinDiff(target));
    }

}