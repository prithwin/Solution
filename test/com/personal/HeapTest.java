package com.personal;

import java.util.*;

import com.personal.util.ComparableNumber;
import com.personal.util.Heap;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/25/17.
 */
public class HeapTest {
    @Test public void testHeapFunctionality() {
        Heap<ComparableNumber> heap = new Heap<>();
        List<ComparableNumber> sortedList = new ArrayList<>();
        ComparableNumber[] comparableNumbers = new ComparableNumber[7];
        comparableNumbers[0] = new ComparableNumber(111);
        comparableNumbers[1] = new ComparableNumber(5);
        comparableNumbers[2] = new ComparableNumber(76);
        comparableNumbers[3] = new ComparableNumber(98);
        comparableNumbers[4] = new ComparableNumber(15);
        comparableNumbers[5] = new ComparableNumber(987);
        comparableNumbers[6] = new ComparableNumber(7);
        heap.elements = comparableNumbers;
        while(!heap.isEmpty()){
            heap.buildMaxHeap();
            sortedList.add(heap.deleteMax());
        }
        System.out.println(sortedList);
    }

    @Test public void testHeapFunctionalityWithTreeElements() {
        Heap<ComparableNumber> heap = new Heap<>();
        List<ComparableNumber> sortedList = new ArrayList<>();
        ComparableNumber[] comparableNumbers = new ComparableNumber[4];
        comparableNumbers[0] = new ComparableNumber(111);
        comparableNumbers[1] = new ComparableNumber(5);
        comparableNumbers[2] = new ComparableNumber(76);
        comparableNumbers[3] = new ComparableNumber(98);
        heap.elements = comparableNumbers;
        while(!heap.isEmpty()){
            heap.buildMaxHeap();
            sortedList.add(heap.deleteMax());
        }
        System.out.println(sortedList);
    }
}
