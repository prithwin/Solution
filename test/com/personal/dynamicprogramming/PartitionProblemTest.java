package com.personal.dynamicprogramming;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/18/17.
 */
public class PartitionProblemTest {
    @Test public void testPartition() {
        int[] target = {1,5,5,11};
        assertTrue(new PartitionProblem().isPartitionPossible(target));
    }

    @Test public void testPartition2() {
        int[] target = {1,5,5,15};
        assertFalse(new PartitionProblem().isPartitionPossible(target));
    }
}
