package com.personal;

import com.personal.util.ComparableNumber;
import com.personal.util.Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajeev on 17/3/17.
 */
public class Sorter<E extends Comparable> {
    /**
     * functioning bubble sort
     * compare everyother number you will find that the largest number would have bubbled up
     * you have do repeat this one less time as the largest number is already at the top.
     *
     * @param targetList
     */
    public void bubbleSort(List<E> targetList) {
        for (int j = targetList.size() - 2; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                if (targetList.get(i).compareTo(targetList.get(i + 1)) == 1) {
                    E temp = targetList.get(i);
                    targetList.set(i, targetList.get(i + 1));
                    targetList.set(i + 1, temp);
                }
            }
        }
    }

    /**
     * functioning selection/ insertion sort
     *
     * @param targetList
     */
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

    /**
     * Generic method that implements Selection Sort.
     * @param targetList
     */
    public void selectionSort(List<E> targetList){
        for(int i = 0 ; i < targetList.size()-1 ; i++) {
            for(int j = i + 1 ; j <targetList.size() ; j++) {
                if(targetList.get(i).compareTo(targetList.get(j)) == 1) {
                    E temp = targetList.get(i);
                    targetList.set(i,targetList.get(j));
                    targetList.set(j,temp);
                }
            }
        }
    }

    /**
     * functioning mergeSort
     *
     * @param targetList
     * @return
     */
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
            } else {
                mergedList.add(rightSublist.get(rPointer));
                mergedList.add(leftSublist.get(lPointer));
                lPointer++;
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

    /**
     * functioning quicksort
     *
     * @param targetList
     * @param start
     * @param end
     */
    public void quickSort(List<E> targetList, int start, int end) {
        if (end - start < 2) {
            if (end - start == 1 && targetList.get(start).compareTo(targetList.get(end)) == 1) {
                E temp = targetList.get(start);
                targetList.set(start, targetList.get(end));
                targetList.set(end, temp);
            }
            return;
        }
        //let the pivot be the middle;
        int pivot = start + (end - start) / 2;
        //int partitionPoint = pivot;
        for (int i = start, j = end; i <= pivot && j >= pivot; ) {
            if (targetList.get(i).compareTo(targetList.get(pivot)) >= 0 &&
                    targetList.get(j).compareTo(targetList.get(pivot)) <= 0) {
                //swap
                E temp = targetList.get(i);
                targetList.set(i, targetList.get(j));
                targetList.set(j, temp);
                if (i == pivot) {
                    pivot = j;
                    break;
                } else if (j == pivot) {
                    pivot = i;
                    break;
                } else {
                    i++;
                    j--;
                }
                continue;

            }
            if (i <= pivot && targetList.get(i).compareTo(targetList.get(pivot)) == -1) {
                i++;
            }
            if (j >= pivot && targetList.get(j).compareTo(targetList.get(pivot)) == 1) {
                j--;
            }
        }

        quickSort(targetList, start, pivot);
        quickSort(targetList, pivot, end);
    }

    /**
     * functioning max heapsort
     *
     * @param targetList
     * @return
     */
    public List<E> maxHeapSort(List<E> targetList) {
        ComparableNumber[] elements = targetList.toArray(new ComparableNumber[0]);
        targetList = new ArrayList<>();
        Heap<E> maxHeap = new Heap<>();
        maxHeap.elements = (E[]) elements;
        while (!maxHeap.isEmpty()) {
            maxHeap.buildMaxHeap();
            targetList.add(maxHeap.deleteMax());
        }
        return targetList;
    }

    /**
     * functioning min heapsort
     *
     * @param targetList
     * @return
     */
    public List<E> minHeapSort(List<E> targetList) {
        ComparableNumber[] elements = targetList.toArray(new ComparableNumber[0]);
        targetList = new ArrayList<>();
        Heap<E> maxHeap = new Heap<>();
        maxHeap.elements = (E[]) elements;
        while (!maxHeap.isEmpty()) {
            maxHeap.buildMinHeap();
            targetList.add(maxHeap.deleteMin());
        }
        return targetList;
    }


    public static void main(String[] args) {
        List<ComparableNumber> numberList = new ArrayList<ComparableNumber>();
        numberList.add(new ComparableNumber(25));
        numberList.add(new ComparableNumber(3));
        numberList.add(new ComparableNumber(5));
        numberList.add(new ComparableNumber(555));
        numberList.add(new ComparableNumber(5355));
        numberList.add(new ComparableNumber(58));
        numberList.add(new ComparableNumber(4));
        numberList.add(new ComparableNumber(1));
        numberList.add(new ComparableNumber(36));
        numberList.add(new ComparableNumber(23));
        numberList.add(new ComparableNumber(5555));
        numberList.add(new ComparableNumber(37));
        numberList.add(new ComparableNumber(39));
        System.out.println("Printing the list before the sort");
        numberList.forEach(Sorter::printElegant);
        Sorter<ComparableNumber> sorter = new Sorter<ComparableNumber>();

//        System.out.println("Sorting using bubble sort");
//        sorter.bubbleSort(numberList);

//        System.out.println("Sorting using insertion sort");
//        sorter.insertionSort(numberList);

//        System.out.println("\nSorting using merge sort");
//        List<ComparableNumber> resultList = sorter.mergeSort(numberList);
//        numberList = resultList;

//        System.out.println("Sorting using quick sort");
//        sorter.quickSort(numberList, 0, numberList.size() - 1);

//        System.out.println("Sorting using max Heap sort");
//        numberList = sorter.maxHeapSort(numberList);

//        System.out.println("Sorting using min Heap sort");
//        numberList = sorter.minHeapSort(numberList);

        System.out.println("sorting using selection sort");
        sorter.selectionSort(numberList);
        numberList.forEach(Sorter::printElegant);
        System.out.println("sum: "+
                numberList.stream()
                        .filter(e -> e.number % 1 == 0)
                        .mapToInt(e -> e.number * 2)
                        .sum()
        );
    }

    private static void printElegant(ComparableNumber comparableNumber) {
        System.out.print(comparableNumber + " , ");
    }
}
