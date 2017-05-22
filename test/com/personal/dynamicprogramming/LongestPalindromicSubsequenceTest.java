package com.personal.dynamicprogramming;

import org.testng.annotations.*;
import static org.testng.Assert.*;
/**
 * Created by pr250155 on 5/21/17.
 */
public class LongestPalindromicSubsequenceTest {

    @Test public void testLPS() {
        assertEquals(7,new LongestPallindromicSubsequence().findSizeOfLongestPallindromicSubsequence("BBABCBCAB"));
        assertEquals(7,new LongestPallindromicSubsequence().longestPalindromicSubsequence("BBABCBCAB"));
    }
}
