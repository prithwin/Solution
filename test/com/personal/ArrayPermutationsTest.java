package com.personal;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.assertTrue;

/**
 * Created by pr250155 on 5/4/17.
 */
public class ArrayPermutationsTest {
    @Test
    public void testArrayPermutations(){
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        List<List<Integer>> result = new ArrayPermutations().permute(inputList);
        result.stream().forEach(l -> l.stream().forEach(i -> assertTrue(inputList.contains(i))));
    }

    @Test
    public void testArrayPermutationsLong(){
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(5);
        inputList.add(6);
        inputList.add(7);
        inputList.add(8);
        List<List<Integer>> result = new ArrayPermutations().permute(inputList);
        result.stream().forEach(l -> l.stream().forEach(i -> assertTrue(inputList.contains(i))));
    }
}
