package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/27/17.
 */
public class TwoArrayMedianTest {
    @Test public void testTwoArrayMedian(){
        int[] thiz = {1,2,3};
        int[] that = {6,7,8,9};
        System.out.println(new TwoArrayMedian().findMedian(thiz, that));
    }
}
