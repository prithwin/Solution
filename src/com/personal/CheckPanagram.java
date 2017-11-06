package com.personal;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by prajeeva on 10/28/17.
 */
public class CheckPanagram {

    public static void main(String[] args) {
        String test = "the quick brown fox   jumps over the lazy dog";
        Set<Character> reg = new HashSet<>();
        IntStream.range(0, test.length()).filter(i -> test.charAt(i) >= 'a' && test.charAt(i)<='z').forEach(i -> reg.add(test.charAt(i)));
        System.out.println("The size of the map is"+ reg.size());
    }
}
