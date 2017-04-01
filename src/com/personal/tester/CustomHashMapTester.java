package com.personal.tester;

import com.personal.util.CustomHashMap;

/**
 * Created by prajeev on 19/3/17.
 */
public class CustomHashMapTester {

    public static void main(String[] args) {
        CustomHashMap<String,String> customHashMap = new CustomHashMap<>();
        customHashMap.put("A1","B1");
        customHashMap.put("A2","B2");
        customHashMap.put("A3","B3");
        customHashMap.put("A4","B4");
        customHashMap.put("A5","B5");
        customHashMap.put("A6","B6");
        System.out.println("test");
        System.out.println(customHashMap.get("A1"));
    }
}
