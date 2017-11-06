package com.random.test.old;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pr250155 on 4/17/17.
 */
public class StreamTester {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("this","that","that1","that2","tha3t");
        System.out.println(myList.stream().map(item -> item+11).map(item -> 11+item).filter(item -> item.length()>8 ).collect(Collectors.toList()));
        Arrays.stream(new int[]{1,2,3,4,5}).forEach(System.out::println);
    }
}
