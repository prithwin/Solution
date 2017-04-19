package com.personal;

/**
 * Created by pr250155 on 4/19/17.
 * given an almost sorted array find the smallest Unsorted Array sorting which makes the entire Array Sorted
 */
public class SmallestUnsortedArray {

    public static void main(String[] args) {
        int[] target = {10,12,20,30,25,40,32,31,35,50,60};
        new SmallestUnsortedArray().printUnsortedArrayIndices(target);
    }

    private void printUnsortedArrayIndices(int[] target) {
        boolean startSwap = false;
        boolean endSwap = false;
        int start = 0;
        int end = 0;
        for ( int i = 0 ; i < target.length -1  ; i++ ) {
            if(target[i] > target[i+1]){
                if(!startSwap) {
                    startSwap = true;
                    start = i;
                }
                int temp = target[i];
                target[i] = target[i+1];
                target[i+1] = temp;
            } else {
                if(startSwap){
                    end = i ;
                }
            }
        }

        System.out.println(start+" -> "+(end-1));
    }
}
