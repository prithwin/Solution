package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajeev on 17/3/17.
 */
public class Sorter<E extends Comparable> {

    public void bubbleSort(List<E> targetList) {
        for (int j = targetList.size(); j > 0; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (targetList.get(i).compareTo(targetList.get(i + 1)) == 1) {
                    E temp = targetList.get(i);
                    targetList.set(i, targetList.get(i + 1));
                    targetList.set(i + 1, temp);
                }
            }
        }
    }

    public void insertionSort(List<E> targetList) {
        for (int i = 0; i < targetList.size(); i++) {
            E swap = targetList.get(i);
            if (targetList.get(i).compareTo(targetList.get(0)) == 1) {
                int j = 0;
                while (targetList.get(++j).compareTo(swap) == -1) {

                }
                targetList.add(j, swap);
            } else {
                targetList.add(0, swap);
            }
            targetList.remove(i + 1);
        }
    }

    public List<E> mergeSort(List<E> targetList) {
        if (targetList.size() == 1) {
            //the list cannot be split anymore
            return targetList;
        }
        if (targetList.size() == 2) {
            if (!(targetList.get(0).compareTo(targetList.get(1)) == -1)) {
                //we must swap the element;
                E swap = targetList.get(0);
                targetList.set(0, targetList.get(1));
                targetList.set(1, swap);
            }
            return targetList;
        }
        int mid = (targetList.size() / 2) - 1;
        List<E> leftSublist = split(targetList, 0, mid);
        leftSublist = mergeSort(leftSublist);
        List<E> rightSublist = split(targetList, mid + 1, targetList.size() - 1);
        rightSublist = mergeSort(rightSublist);
        return merge(leftSublist, rightSublist);
    }

    private List<E> merge(List<E> leftSublist, List<E> rightSublist) {
        List<E> mergedList = new ArrayList<E>();
        int lPointer = 0;
        int rPointer = 0;
        while (lPointer < leftSublist.size() || rPointer < rightSublist.size()) {

            if (rPointer == rightSublist.size() ||
                    (lPointer < leftSublist.size() && leftSublist.get(lPointer).
                            compareTo(rightSublist.get(rPointer)) == -1)) {
                mergedList.add(leftSublist.get(lPointer));
                lPointer++;
            } else if (lPointer == leftSublist.size() ||
                    (rPointer < rightSublist.size() && leftSublist.get(lPointer).
                            compareTo(rightSublist.get(rPointer)) == 1)) {
                mergedList.add(rightSublist.get(rPointer));
                rPointer++;
            }
        }

        return mergedList;
    }

    private List<E> split(List<E> targetList, int start, int end) {
        List<E> returnList = new ArrayList<E>();
        for (int i = start; i <= end; i++) {
            returnList.add(targetList.get(i));
        }
        return returnList;
    }

    public void quickSort(List<E> targetList, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        //let the pivot be rightmostElement;
        int pivot = end;
        int partitionPoint = pivot;
        for (int i = start; i < partitionPoint; i++) {
            if (targetList.get(i).compareTo(targetList.get(pivot)) == 1) {
                targetList.add(partitionPoint + 1, targetList.get(i));
                targetList.remove(i);
                partitionPoint--;
                i--;
            }
        }

        quickSort(targetList, start, partitionPoint);
        quickSort(targetList, partitionPoint + 1, end);
    }

    static class NonComparableNumber {
    }

    static class Number implements Comparable {
        int number;

        Number(int i) {
            this.number = i;
        }

        @Override
        public boolean equals(Object obj) {
            Number rhs = (Number) obj;
            return number == rhs.number;
        }


        @Override
        public int compareTo(Object that) {
            Number thats = (Number) that;
            if (this.number == thats.number)
                return 0;
            return (this.number - thats.number) / ((this.number - thats.number) > 0 ? (this.number - thats.number) : -1 * (this.number - thats.number));
        }

        @Override
        public String toString() {
            return "" + number;
        }
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<Number>();
        numberList.add(new Number(3));
        numberList.add(new Number(5));
        numberList.add(new Number(555));
        numberList.add(new Number(5555));
        numberList.add(new Number(58));
        numberList.add(new Number(1));
        numberList.add(new Number(36));
        numberList.add(new Number(23));
        numberList.add(new Number(37));
        numberList.add(new Number(39));
        Sorter<Number> sorter = new Sorter<Number>();

//        System.out.println("Sorting using bubble sort");
//        sorter.bubbleSort(numberList);

//        System.out.println("Sorting using insertion sort");
//        sorter.insertionSort(numberList);

//        System.out.println("Sorting using merge sort");
//        List<Number> resultList = sorter.mergeSort(numberList);
//        numberList = resultList;

        System.out.println("Sorting using quick sort");
        sorter.quickSort(numberList, 0, numberList.size() - 1);

        System.out.println(numberList);
    }
}
