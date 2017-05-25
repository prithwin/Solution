package com.personal;

import org.testng.annotations.*;
import java.util.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/24/17.
 */
public class BasicArraysTest {
    @Test public void testReverseArray() {
        Integer[] test = {1,2,3,4};
        BasicArrays.inPlaceReverse(test);
        for (Integer item : test) {
            System.out.println(item);
        }
    }
}
