package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/29/17.
 */
public class FindKLargestElementsTest {
    @Test
    public void testTopKFrequent() throws Exception {
        int[] target = {1,1,1,2,2,3,Integer.MAX_VALUE};
        System.out.println(new FindKLargestElements().topKFrequent(target,2));

    }

}