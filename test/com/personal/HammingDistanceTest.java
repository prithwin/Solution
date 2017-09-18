package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 9/17/17.
 */
public class HammingDistanceTest {
    @Test
    public void testHammingDistance() throws Exception {
        new HammingDistance().hammingDistance(56,89);

    }

}