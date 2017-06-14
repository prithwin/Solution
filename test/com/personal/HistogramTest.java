package com.personal;

import java.util.*;
import static org.testng.Assert.*;

import com.personal.util.Histogram;
import org.testng.annotations.*;

/**
 * Created by prith on 14-06-2017.
 */
public class HistogramTest {
    @Test public void testHistogramFunctionality() {
        int[] histogram = {6, 2, 5, 4, 5, 1, 6};
        assertEquals(new Histogram(histogram).getMaximumContinuousArea().area,12);
    }
    @Test public void testHistogramFunctionalitySC() {
        int[] histogram = {4,4,5,4,2};
        assertEquals(new Histogram(histogram).getMaximumContinuousArea().area,16);
    }

    @Test public void testHistogramFunctionality1() {
        int[] histogram = {1,3,2,1,2};
        assertEquals(new Histogram(histogram).getMaximumContinuousArea().area,5);
    }

    @Test public void testHistogramFunctionality2() {
        int[] histogram = {1,1,2,3};
        assertEquals(new Histogram(histogram).getMaximumContinuousArea().area,4);
    }

    //2, 1, 3, 5, 1, 3, 3

    @Test public void testHistogramFunctionality3() {
        int[] histogram = {2, 1, 3, 5, 1, 3, 3};
        assertEquals(new Histogram(histogram).getMaximumContinuousArea().area,7);
    }

    @Test public void testHistogramFunctionality4() {
        int[] histogram = {2, 1, 3, 5, 0, 3, 3};
        assertEquals(new Histogram(histogram).getMaximumContinuousArea().area,6);
    }

}

