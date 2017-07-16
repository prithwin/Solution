package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by prajeeva on 7/15/17.
 */
public class MergeIntervalsTest {
    @Test
    public void testMerge() throws Exception {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(0,4));

        System.out.println(new MergeIntervals().merge(intervals));
    }

}