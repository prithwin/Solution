package com.personal;

import com.personal.util.Mathematical;
import org.testng.annotations.Test;

import java.util.List;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/4/17.
 */
public class StringPermuteTest {

    @Test
    public void testStringPermutationABCD() {
        String testString = "ABCD";
        List<String> result = new StringPermutation().permute(testString);
        result.
                parallelStream().
                forEach(s -> {
                    for (char c : testString.toCharArray()) {
                        assertTrue(s.contains(c + ""));
                    }
                }
                );
        assertTrue(result.size() == Mathematical.factorial(4));
    }

    @Test
    public void testStringABCDEF() {
        String testString = "ABCDEF";
        List<String> result = new StringPermutation().permute(testString);
        result.
                parallelStream().
                forEach(s -> { for(char c:testString.toCharArray()) {assertTrue(s.contains(c+""));}}
                );
        assertTrue(result.size() == Mathematical.factorial(6));
    }

}
