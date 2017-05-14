package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
/**
 * Created by pr250155 on 5/14/17.
 */
public class LongestSubstringWithNoRepeatsTest {
    @Test public void findAnswers() {
        assertEquals("KSFORGE",new LongestSubstringWithNoRepeats().longestSubstringWithNoRepeats("GEEKSFORGEEKS"));
        assertEquals("abcdefghE",new LongestSubstringWithNoRepeats().longestSubstringWithNoRepeats("1234EEabcdefghEE5678"));
    }
}
