package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 8/6/17.
 */
public class MaxSlidingWindowTest {
    @Test
    public void testMaxSlidingWindow() throws Exception {
        int[] target = {1};
        int[] resposne = new MaxSlidingWindow().maxSlidingWindow(target,1);
        System.out.println();
    }

}