package com.personal;

import com.personal.util.ComparableNumber;
import com.personal.util.CustomHashMap;
import com.personal.util.Heap;
import com.personal.util.MapNode;

import java.util.*;

/**
 * Created by prajeev on 17/3/17.
 */
public class Sorter<E extends Comparable> {
    /**
     * functioning bubble sort
     * compare every other number you will find that the largest number would have bubbled up
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
     *
     * @param items
     * @return
     */
    public List<Integer> countingSort(List<Integer> items) {
        List<Integer> result = new ArrayList();
        CustomHashMap<Integer,Integer> registry = new CustomHashMap<>();
        items.stream().forEach(i -> countingAdd(registry,i));
        for(MapNode<Integer,Integer> node : registry.getBuckets()){
            if(node!=null){
                addNTimes(result,node.getKey(),node.getValue());
            }
        }
        return result;
    }

    private void addNTimes(List<Integer> result, Integer value, Integer count) {
        for(int i = 0 ; i < count ; i++) {
            result.add(value);
        }
    }

    private void countingAdd(CustomHashMap<Integer, Integer> registry, Integer item) {
        if(registry.containsKey(item)){
            registry.put(item, (registry.get(item) + 1));
        } else {
            registry.put(item,1);
        }
    }

    /**
     * functioning selection/ insertion sort
     *
     * @param targetList
     */
    public void insertionSort(List<E> targetList) {
        for (int i = 1 ; i < targetList.size() ; i++){
            for ( int j =  i ; j > 0 ; j--) {
                if(targetList.get(j-1).compareTo(targetList.get(j)) == 1) {
                    E temp = targetList.get(j-1);
                    targetList.set(j-1,targetList.get(j));
                    targetList.set(j,temp);
                }
            }
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

    public void mergeSort(int[] target,int start, int end) {
        if(start >= end) return;
        if(end - start == 1) {
            if(target[start] > target[end]) {
                int temp = target[start];
                target[start] = target[end];
                target[end] = temp;
                return;
            }
        }

        int mid = start + ((end - start) / 2);
        mergeSort(target,start,mid);
        mergeSort(target,mid+1,end);
        merge(target,start,mid,mid+1,end);
    }

    private void merge(int[] target, int leftStart, int leftEnd, int rightStart, int rightend) {
        int i = leftStart;
        int j = rightStart;
        int[] tempArray = new int[rightend-leftStart+1];
        int k = 0;
        while(i<= leftEnd && j<=rightend) {
            if(target[i] < target[j]) {
               tempArray[k++] = target[i++];
            }else if(target[j] < target[i]) {
                tempArray[k++] = target[j++];
            } else {
                tempArray[k++] = target[j++];
                tempArray[k++] = target[i++];
            }
        }
        while(j <= rightend){
            tempArray[k++] = target[j++];
        }
        while(i <= leftEnd){
            tempArray[k++] = target[i++];
        }
        for(int l = leftStart,n=0 ; l <=rightend ; l++,n++) {
            target[l] = tempArray[n];
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

   public void quickSort(List<E> targetList) {
       quickSort(targetList,0,targetList.size()-1);
   }

    private void quickSort(List<E> targetList, int start, int end) {
        if (end - start < 2) {
            if (end - start == 1 && targetList.get(start).compareTo(targetList.get(end)) == 1) {
                E temp = targetList.get(start);
                targetList.set(start, targetList.get(end));
                targetList.set(end, temp);
            }
            return;
        }
        int pivot = partition(targetList,start,end);
        quickSort(targetList,start,pivot-1);
        quickSort(targetList,pivot+1,end);
    }

    private int partition(List<E> target,int start,int end) {
        int pivot = start;
        start++;
        while(start <= end) {
            while(start <= end && target.get(start).compareTo(target.get(pivot)) == -1 ) start++;
            while(start <= end && target.get(end).compareTo(target.get(pivot)) >= 0) end--;
            if(start > end) break;
            E temp = target.get(start);
            target.set(start,target.get(end));
            target.set(end,temp);
        }
        E temp = target.get(end);
        target.set(end,target.get(pivot));
        target.set(pivot,temp);
        return end;
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
}
