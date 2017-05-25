package com.personal;

/**
 * Created by pr250155 on 5/25/17.
 */
public class MergeSortedArray {
    public int[] mergeSortedArray(int[] thiz, int[] that) {
        int i = 0 , j = 0;
        int k = 0;
        int[] result = new int[thiz.length + that.length];

        while(i <thiz.length && j < that.length) {
            if(thiz[i] < that[j]) {
                result[k++] = thiz[i++];
            } else if(that[j] < thiz[i]) {
                result[k++] = that[j++];
            } else {
                result[k++] = thiz[i++];
                result[k++] = that[j++];
            }
            if(i == thiz.length) {
                while(j< that.length) {
                    result[k++] = that[j++];
                }
            }
            if(j == that.length) {
                while(i < thiz.length) {
                    result[k++] = thiz[i++];
                }
            }

        }
        return result;
    }
}
