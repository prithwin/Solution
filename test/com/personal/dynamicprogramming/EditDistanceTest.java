package com.personal.dynamicprogramming;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/4/17.
 */
public class EditDistanceTest {
    @Test
    public void testGetEditDistanceRR() throws Exception {
        System.out.println(new EditDistance().getEditDistanceRR("horizon","horazon"));
    }

    @Test
    public void testGetEditDistanceMemoized() throws Exception {
        System.out.println(new EditDistance().getEditDistance("horizon","horazon"));
    }

    @Test
    public void testGetEditDistanceMemoized2() throws Exception {
        System.out.println(new EditDistance().getEditDistance("horizon","horazontal"));
    }

}