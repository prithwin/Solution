package com.personal;

import com.personal.util.ComparableNumber;
import org.testng.annotations.*;
import java.util.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/23/17.
 */
public class SorterTest {
    @Test public void testCountingSort() {
        List<Integer> testList = Arrays.asList(22,1,2,55,33,99,76,5,22,88,88,22);
        List<Integer> result = new Sorter<ComparableNumber>().countingSort(testList);
        result.stream().forEach(System.out::println);
    }

    @Test public void testQuickSort() {
        List<ComparableNumber> numberList = getTestList();
        System.out.println("Printing the list before the sort");
        numberList.forEach(ComparableNumber::printElegant);
        Sorter<ComparableNumber> sorter = new Sorter<ComparableNumber>();
        sorter.quickSort(numberList);
        System.out.println("\nPrinting the Same List after the sort");
        numberList.forEach(ComparableNumber::printElegant);
    }

    @Test public void testInPlaceMergeSort() {
        int[] testArray = {22,1,2,55,33,99,76,5,22,88,88,22};
        new Sorter<Integer>().mergeSort(testArray,0,testArray.length-1);
        for(int num : testArray) {
            System.out.println(num);
        }
    }

    @Test public void testRegularMergeSort() {
        List<ComparableNumber> numberList = getTestList();
        System.out.println("Printing the list before the sort");
        numberList.forEach(ComparableNumber::printElegant);
        List<ComparableNumber> result = new Sorter<ComparableNumber>().mergeSort(numberList);
        System.out.println("\nPrinting the Same List after the sort");
        result.forEach(ComparableNumber::printElegant);
    }

    @Test public void testSelectionSort() {
        List<ComparableNumber> numberList = getTestList();
        System.out.println("Printing the list before the sort");
        numberList.forEach(ComparableNumber::printElegant);
        Sorter<ComparableNumber> sorter = new Sorter<>();
        sorter.selectionSort(numberList);
        System.out.println("\nPrinting the Same List after the sort");
        numberList.forEach(ComparableNumber::printElegant);
    }

    @Test public void testInsertionSort() {
        List<ComparableNumber> numberList = getTestList();
        System.out.println("Printing the list before the sort");
        numberList.forEach(ComparableNumber::printElegant);
        Sorter<ComparableNumber> sorter = new Sorter<>();
        sorter.insertionSort(numberList);
        System.out.println("\nPrinting the Same List after the sort");
        numberList.forEach(ComparableNumber::printElegant);
    }

    @Test public void testBubbleSort() {
        List<ComparableNumber> numberList = getTestList();
        System.out.println("Printing the list before the sort");
        numberList.forEach(ComparableNumber::printElegant);
        Sorter<ComparableNumber> sorter = new Sorter<>();
        sorter.bubbleSort(numberList);
        System.out.println("\nPrinting the Same List after the sort");
        numberList.forEach(ComparableNumber::printElegant);
    }

    @Test public void testMaxHeapSort() {
        List<ComparableNumber> numberList = getTestList();
        System.out.println("Printing the list before the sort");
        numberList.forEach(ComparableNumber::printElegant);
        List<ComparableNumber> result = new Sorter<ComparableNumber>().maxHeapSort(numberList);
        System.out.println("\nPrinting the Same List after the sort");
        result.forEach(ComparableNumber::printElegant);
    }

    @Test public void testMinHeapSort() {
        List<ComparableNumber> numberList = getTestList();
        System.out.println("Printing the list before the sort");
        numberList.forEach(ComparableNumber::printElegant);
        List<ComparableNumber> result = new Sorter<ComparableNumber>().minHeapSort(numberList);
        System.out.println("\nPrinting the Same List after the sort");
        result.forEach(ComparableNumber::printElegant);
    }

    private List<ComparableNumber> getTestList() {
        List<ComparableNumber> numberList = new ArrayList<>();
        numberList.add(new ComparableNumber(25));
        numberList.add(new ComparableNumber(3));
        numberList.add(new ComparableNumber(5));
        numberList.add(new ComparableNumber(36));
        numberList.add(new ComparableNumber(555));
        numberList.add(new ComparableNumber(5355));
        numberList.add(new ComparableNumber(58));
        numberList.add(new ComparableNumber(4));
        numberList.add(new ComparableNumber(1));
        numberList.add(new ComparableNumber(36));
        numberList.add(new ComparableNumber(23));
        numberList.add(new ComparableNumber(5555));
        numberList.add(new ComparableNumber(37));
        numberList.add(new ComparableNumber(36));
        numberList.add(new ComparableNumber(39));
        return numberList;
    }
}
