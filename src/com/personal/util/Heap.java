package com.personal.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by pr250155 on 3/31/17.
 */
public class Heap<E extends Comparable> {
    public E[] elements;

    public void buildMaxHeap(){
        for(int i = elements.length-1 ; i >= 0  ; i-=2){
            int rootIndex = ((i+1)/2)-1;
            int leftChildIndex = i-1;
            int rightChildIndex = i;

            if(leftChildIndex>= 0 && rootIndex>=0 && rightChildIndex>=0) {
                if (elements[rootIndex].compareTo(elements[leftChildIndex]) == -1) {
                    E temp = elements[rootIndex];
                    elements[rootIndex] = elements[leftChildIndex];
                    elements[leftChildIndex] = temp;
                }
                if (elements[rootIndex].compareTo(elements[rightChildIndex]) == -1) {
                    E temp = elements[rootIndex];
                    elements[rootIndex] = elements[rightChildIndex];
                    elements[rightChildIndex] = temp;
                }
            }

        }
    }

    public void buildMinHeap(){
        for(int i = elements.length-1 ; i >= 0  ; i-=2){
            int rootIndex = ((i+1)/2)-1;
            int leftChildIndex = i-1;
            int rightChildIndex = i;

            if(leftChildIndex>= 0 && rootIndex>=0 && rightChildIndex>=0) {
                if (elements[rootIndex].compareTo(elements[leftChildIndex]) == 1) {
                    E temp = elements[rootIndex];
                    elements[rootIndex] = elements[leftChildIndex];
                    elements[leftChildIndex] = temp;
                }
                if (elements[rootIndex].compareTo(elements[rightChildIndex]) == 1) {
                    E temp = elements[rootIndex];
                    elements[rootIndex] = elements[rightChildIndex];
                    elements[rightChildIndex] = temp;
                }
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(E element : elements) {
            builder.append(element.toString()+" , ");
        }
        return builder.toString();
    }

    public E deleteMax() {
        E temp = elements[0];
        ComparableNumber[] revisedArray = new ComparableNumber[elements.length-1];
        for(int i =1 ;i < elements.length ; i++){
            revisedArray[i-1] = (ComparableNumber)elements[i];
        }
        this.elements = (E[])revisedArray;
        return temp;
    }

    public E deleteMin() {
        E temp = elements[0];
        ComparableNumber[] revisedArray = new ComparableNumber[elements.length-1];
        for(int i =1 ;i < elements.length ; i++){
            revisedArray[i-1] = (ComparableNumber)elements[i];
        }
        this.elements = (E[])revisedArray;
        return temp;
    }

    public boolean isEmpty() {
        if(elements.length==0){
            return true;
        }
        return false;
    }
}
