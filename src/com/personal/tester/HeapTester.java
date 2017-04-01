package com.personal.tester;

import com.personal.util.ComparableNumber;
import com.personal.util.Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 3/31/17.
 */
public class HeapTester {

    public static void main(String[] args) {
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
}
