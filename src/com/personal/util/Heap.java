package com.personal.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by pr250155 on 3/31/17.
 */
public class Heap<E extends Comparable> implements Externalizable{
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

    /**
     * The object implements the writeExternal method to save its contents
     * by calling the methods of DataOutput for its primitive values or
     * calling the writeObject method of ObjectOutput for objects, strings,
     * and arrays.
     *
     * @param out the stream to write the object to
     * @throws java.io.IOException Includes any I/O exceptions that may occur
     * @serialData Overriding methods should use this tag to describe
     * the data layout of this Externalizable object.
     * List the sequence of element types and, if possible,
     * relate the element to a public/protected field and/or
     * method of this Externalizable class.
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    /**
     * The object implements the readExternal method to restore its
     * contents by calling the methods of DataInput for primitive
     * types and readObject for objects, strings and arrays.  The
     * readExternal method must read the values in the same sequence
     * and with the same types as were written by writeExternal.
     *
     * @param in the stream to read data from in order to restore the object
     * @throws java.io.IOException    if I/O errors occur
     * @throws ClassNotFoundException If the class for an object being
     *                                restored cannot be found.
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
