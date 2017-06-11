package com.personal.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 3/31/17.
 * a heap is implemented with the help of an array.
 * the heap property can mathematically be expressed by if an element is at the position n
 * then its children will be at the position 2n and 2n + 1.
 * for example
 *                1             =     1 2 3 4 5 6 7
 *             2    3
 *            4 5  6 7
 *
 *            imples that we can figure out the parent of an index i by first doing
 *   if the left and right children are i and i-1 then the parent can be deduced by having the euqation
 *   i + 1 = 2 (r+1)  // n = ((i+1) / 2) - 1 //
 */
public class Heap<E extends Comparable> {
    public E[] elements;

    public Heap() {

    }

    public Heap(List<E> list) {
        Comparable[] elements = new Comparable[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            elements[i] = list.get(i);
        }
        this.elements = (E[])elements;
    }

    public void buildMaxHeap(){
        for(int i = elements.length-1 ; i > 0  ; i-=2){
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
        for(int i = elements.length-1 ; i > 0  ; i-=2){
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
        this.elements = Arrays.copyOfRange(elements,1,elements.length);
        return temp;
    }

    public E deleteMin() {
        E temp = elements[0];
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
