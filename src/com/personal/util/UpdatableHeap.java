package com.personal.util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by prith on 09-06-2017.
 */
public class UpdatableHeap<U extends Updatable & Comparable> extends Heap {
    U[] elements;

    public UpdatableHeap(List<U> list) {
        Updatable[] elements = new Updatable[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            elements[i] = list.get(i);
        }
        this.elements = (U[])elements;
    }


    public boolean reduceKey(U updatable, int newValue){
        boolean isupdated = false;
        for(int i = elements.length-1 ; i > 0  ; i-=2){
            int rootIndex = ((i+1)/2)-1;
            int leftChildIndex = i-1;
            int rightChildIndex = i;
            if(updatable.equals(elements[leftChildIndex])){
                isupdated = elements[leftChildIndex].update(newValue);
            } else if(updatable.equals(elements[rightChildIndex])){
                isupdated = elements[rightChildIndex].update(newValue);
            } else if(updatable.equals(elements[rootIndex])){
                isupdated = elements[rootIndex].update(newValue);
            }

            if(leftChildIndex>= 0 && rootIndex>=0 && rightChildIndex>=0) {
                if (elements[rootIndex].compareTo(elements[leftChildIndex]) == 1) {
                    U temp = elements[rootIndex];
                    elements[rootIndex] = elements[leftChildIndex];
                    elements[leftChildIndex] = temp;
                }
                if (elements[rootIndex].compareTo(elements[rightChildIndex]) == 1) {
                    U temp = elements[rootIndex];
                    elements[rootIndex] = elements[rightChildIndex];
                    elements[rightChildIndex] = temp;
                }
            }

        }
        return isupdated;
    }

    public U deleteMin() {
        U temp = elements[0];
        this.elements = Arrays.copyOfRange(elements,1,elements.length);
        return temp;
    }

    public boolean isEmpty() {
        if(this.elements.length==0){
            return true;
        }
        return false;
    }
}
