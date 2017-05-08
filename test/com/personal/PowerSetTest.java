package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Arrays;

/**
 * Created by pr250155 on 5/6/17.
 */
public class PowerSetTest {
    @Test
    public void testPowerSet(){
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b','c')).contains(Arrays.asList('c')));
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b','c')).contains(Arrays.asList('a')));
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b','c')).contains(Arrays.asList('b')));
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b','c')).contains(Arrays.asList('a','c')));
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b','c')).contains(Arrays.asList('a','b')));
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b','c')).contains(Arrays.asList('b','c')));
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b','c')).contains(Arrays.asList('a','b','c')));
    }

    @Test
    public void testPowerSet2(){
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b')).contains(Arrays.asList('a')));
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b')).contains(Arrays.asList('b')));
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b')).contains(Arrays.asList('a','b')));
    }


    @Test
    public void testPowerSet4(){
        assertTrue(new CalculatePowerSet().getPowerSet(Arrays.asList('a','b','c','d')).contains(Arrays.asList('a','b','c','d')));
    }
}
