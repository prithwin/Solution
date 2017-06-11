package com.personal;

import com.personal.dynamicprogramming.RodCutting;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by prith on 11-06-2017.
 */
public class RodCuttingTest {
    @Test public void testRodCutting() {
        int[] values = {1, 5, 8, 9, 10, 17, 17, 20};
        assertEquals(new RodCutting().getMaxValue(values,8), new RodCutting().getMaxValue(values));
    }
}
