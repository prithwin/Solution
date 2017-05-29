package com.personal.dynamicprogramming;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/29/17.
 */
public class BinomialCoefficientTest {
    @Test public void testnCr() {
        assertEquals(1,new BinomialCoefficient().C(32,32));
        assertEquals(225792840,new BinomialCoefficient().C(32,12));
        assertEquals(210,new BinomialCoefficient().C(10,4));
    }

    @Test public void testnCrNonDp() {
        assertEquals(1,new BinomialCoefficient().C2(32,32));
        assertEquals(225792840,new BinomialCoefficient().C2(32,12));
        assertEquals(210,new BinomialCoefficient().C2(10,4));
    }
}
