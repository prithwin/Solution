package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/25/17.
 */
public class ThreeSumEqualsKTest {
    @Test public void testThreeSumEqualsKTrue() {
        int[] target = {12,3,4,1,6,9};
        assertTrue(new ThreeSumEqualsK().isCombinationPossible(target,24));
    }
    @Test public void testThreeSumEqualsKFalse() {
        int[] target = {12,3,4,1,6,9};
        assertFalse(new ThreeSumEqualsK().isCombinationPossible(target,20));
    }

    @Test public void testThreeSumEqualsKTrue2() {
        int[] target = {12,3,4,1,6,9};
        assertTrue(new ThreeSumEqualsK().isCombinationPossible(target,21));
    }

    @Test public void testThreeSumEqualsKFalse2() {
        int[] target = {12,3,4,1,6,9};
        assertFalse(new ThreeSumEqualsK().isCombinationPossible(target,2100));
    }
}
