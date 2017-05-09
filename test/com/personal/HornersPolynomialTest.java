package com.personal;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/9/17.
 */
public class HornersPolynomialTest {
    @Test public void computePolynomial() {
        System.out.print(new HornersPolynomial().compute(Arrays.asList(2, -1, 3, 1, -5),3));
    }
}
