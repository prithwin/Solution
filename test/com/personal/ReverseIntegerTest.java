package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/20/17.
 */
public class ReverseIntegerTest {
    @Test public void testReverse() {
        assertEquals(4321,new ReverseInteger().reverse(1234));
        assertEquals(54321,new ReverseInteger().reverse(12345));
        assertEquals(584321,new ReverseInteger().reverse(123485));
        assertEquals(2584321,new ReverseInteger().reverse(1234852));
        assertEquals(-2584321,new ReverseInteger().reverse(-1234852));
        assertEquals(3,new ReverseInteger().reverse(3));
        assertEquals(0,new ReverseInteger().reverse(0));
    }
}
