package com.personal;

import com.personal.util.CustomHashMap;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/22/17.
 */
public class CustomHashMapTester {
    @Test public void testHashMap() {
        CustomHashMap<String,String> customHashMap = new CustomHashMap<>();
        customHashMap.put("A1","B1");
        customHashMap.put("A2","B2");
        customHashMap.put("A3","B3");
        customHashMap.put("A4","B4");
        customHashMap.put("A5","B5");
        customHashMap.put("A6","B6");
        assertTrue(customHashMap.containsKey("A1"));
        assertTrue(customHashMap.containsKey("A2"));
        assertEquals("B1",customHashMap.get("A1"));

    }
}
