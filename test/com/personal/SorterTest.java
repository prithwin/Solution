package com.personal;

import org.testng.annotations.*;
import java.util.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/23/17.
 */
public class SorterTest {
    @Test public void testCountingSort() {
        List<Integer> testList = Arrays.asList(22,1,2,55,33,99,76,5,22,88,88,22);
        List<Integer> result = new Sorter().countingSort(testList);
        result.stream().forEach(System.out::println);
    }
}
