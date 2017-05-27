package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/27/17.
 */
public class TwoNumberSumTest {
    @Test public void testTwoNumberSum() {
        int[] testArray = {1,2,3,4,5,6,7,8,9,10};
        assertTrue(new TwoNumberSum().twoSum(testArray,19).contains(9));
        assertTrue(new TwoNumberSum().twoSum(testArray,19).contains(10));
    }
}
