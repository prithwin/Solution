package com.personal;

/**
 * Created by prajeeva on 7/12/17.
 */
public class MedianOfTwoSortedArrays {

    /**
     * ordinary lifesayer code.
     * @param thiz
     * @param that
     * @return
     */
    public double findMedianSortedArrays(int[] thiz , int[] that) {
        int[] mergeResult = new int[thiz.length + that.length];
        int i = 0 , j = 0 , k = 0;
        while(i < thiz.length && j < that.length) {
            if(thiz[i] < that[j]) {
                mergeResult[k++] = thiz[i++];
            } else if(that[j] < thiz[i]) {
                mergeResult[k++] =that[j++];
            } else {
                mergeResult[k++] = thiz[i++];
                mergeResult[k++] = that[j++];
            }
        }
        if(i == thiz.length) {
            while( j < that.length) {
                mergeResult[k++] = that[j++];
            }
        }
        if(j == that.length) {
            while(i < thiz.length) {
                mergeResult[k++] = thiz[i++];
            }
        }
        if(mergeResult.length % 2 != 0) {
            return mergeResult[mergeResult.length / 2];
        } else {
            return ((double)(mergeResult[mergeResult.length / 2 ]) + ((double) mergeResult[(mergeResult.length / 2) - 1])) / 2;
        }

    }

}
