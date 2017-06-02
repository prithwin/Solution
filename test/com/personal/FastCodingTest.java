package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/25/17.
 */
public class FastCodingTest {

    @Test public void reverseStringtest() {
        String target ="PRITHWIN";
        assertEquals("NIWHTIRP",new String(reverse(target.toCharArray(),0, target.length()-1)));
    }

    private char[] reverse(char[] chars, int start, int end) {
        if(start>end) return chars;
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        return reverse(chars,start + 1, end -1);
    }

    @Test public void testPalindromeFasle() {
       assertFalse(isPalindrome("ASPRIN"));
   }

    @Test public void testPalindromeTrue() {
        assertTrue(isPalindrome("MalayalaM"));
    }

    @Test public void testPalindromeTrueOdd() {
        assertTrue(isPalindrome("MalaalaM"));
    }

    @Test public void testPalindromeTrueEven() {
        assertTrue(isPalindrome("MalaalaM"));
    }

    @Test public void testFloatingPoint() {
        System.out.println((1f/3f) + (1f/3f) + (1f/3f));
    }


    private boolean isPalindrome(String text) {
        if(text.length() <= 1) return true;
        if(text.charAt(0) == text.charAt(text.length() - 1)) return isPalindrome(text.substring(1,text.length()-1));
        return false;
    }
}
