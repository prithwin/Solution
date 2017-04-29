package com.random.test;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;

/**
 * Created by pr250155 on 4/26/17.
 */
public class CollectionsTest {
    public static void main(String[] args){
        Map<Integer,String> testMap = new HashMap<>();
        testMap.put(null,null);
        Set<String> testSet = new HashSet<>();
        testSet.add(null);
        String something = null;
        System.out.println(something.hashCode());
        System.out.printf("wait");
    }
}
