package com.personal;

import com.personal.dynamicprogramming.BinomialCoefficient;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/29/17.
 */
public class PermutationAndCombinationsTest {
    @Test public void testCombinationGenerator() {
        List<String> target = Arrays.asList("A", "B", "C", "D", "E", "F");
        int r = 3;
        Set<String> result = new PermutationsAndCombinations<String>().C(target, r);
        assertEquals(result.size(), new BinomialCoefficient().C(target.size(),r));
        result.stream().forEach(System.out::println);
    }
}