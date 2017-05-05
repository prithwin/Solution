package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/5/17.
 */
public class BracesEqualPointTest {
    @Test
    public void testEqualPoint() {
        assertEquals(9,new BracesEqualPoint().findEqualPoint("(()))(()()())))"));
    }
}
