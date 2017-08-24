package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 8/6/17.
 */
public class HistogramWaterTankTest {
    @Test
    public void testTrap() throws Exception {
        int[] t = {4,2,0,3,2,4,3,4};
        System.out.println(new HistogramWaterTank().trapR(t));

    }

    @Test
    public void testTrap3() throws Exception {
        int[] t = {5,2,1,2,1,5};
        System.out.println(new HistogramWaterTank().trap(t));

    }

    @Test
    public void testTrap3R() throws Exception {
        int[] t = {5,2,1,2,1,5};
        System.out.println(new HistogramWaterTank().trapR(t));

    }

    @Test
    public void testTrap2() throws Exception {
        int[] t = {4,2,3};
        System.out.println(new HistogramWaterTank().trap(t));

    }

}