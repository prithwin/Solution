package com.personal;

/**
 * Created by pr250155 on 1/21/16.
 */
public class TwoArrayMedian {

    public int findMedian(int[] thiz, int[] that) {
        int[] mergedArray = new int [thiz.length + that.length] ;
        int i = 0 , j = 0;
        int k = 0 ;

        while(i < thiz.length && j < that.length) {
            if(thiz[i] < that[j]) {
                mergedArray[k++] = thiz[i++];
            } else if(that[j] < thiz[i]) {
                mergedArray[k++] = that[j++];
            } else {
                mergedArray[k++] = thiz[i++];
                mergedArray[k++] = that[j++];
            }
        }
        if(i == thiz.length) {
            while(j < that.length) {
                mergedArray[k++] = that[j++];
            }
        }

        if(j == that.length) {
            while(i<thiz.length) {
                mergedArray[k++] = thiz[i++];
            }
        }

        return mergedArray[mergedArray.length >> 1];
    }

}
