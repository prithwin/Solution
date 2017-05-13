package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/13/17.
 */
public class LongestPallindromicSubstringTest {
    @Test public void testLongestPalindromicSubstring(){
        assertEquals(new LongestPallindromicSubstring().find("WERSDGJNXDSERabbaERTERTERTTR"),"abba");
        assertNotEquals(new LongestPallindromicSubstring().find("WERSDGJNXDSERMALAYALAMERTERTERTTR"),"abba");
        assertEquals(new LongestPallindromicSubstring().find("WERSDGJNXDSERmalayalamERTERTERTTR"),"malayalam");
    }
}

