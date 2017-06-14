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
        System.out.println(new Histogram(histogram).getMaximumContinuousArea().area);
    }
}

