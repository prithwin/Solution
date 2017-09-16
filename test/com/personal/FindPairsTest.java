package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 9/15/17.
 */
public class FindPairsTest {
    @Test
    public void testFindPairs() throws Exception {
        int[] target = {3, 1, 4, 1, 5};
        System.out.println(new FindPairs().findPairs(target,2));
    }

}