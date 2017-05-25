package com.personal;

/**
 * Created by pr250155 on 5/24/17.
 */
public class BasicArrays {
    public static<E> void inPlaceReverse(E[] array) {
        for(int i = 0, j = array.length-1 ; i<j ; i++, j--) {
            E temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
