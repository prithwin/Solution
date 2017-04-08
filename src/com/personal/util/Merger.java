package com.personal.util;

import java.util.Arrays;

/**
 * Created by pr250155 on 4/8/17.
 */
public class Merger<T extends Comparable> {
    public MergeResult merge(T[] thisArray, T[] thatArray) {
        MergeResult mergeResult = new MergeResult();
        int thisArrayLength = thisArray.length;
        int thatArrayLength = thatArray.length;
        int combinedLength = thisArrayLength + thatArrayLength;
        mergeResult.resultArray = new Object[thisArray.length+thatArray.length];
        mergeResult.resultIndex = new Boolean[thisArray.length+thatArray.length];


        for(int i = 0, j = 0 , k=0 ; k < combinedLength ; ){
            if((i<thisArrayLength) && (j >= thatArrayLength-1 || (thisArray[i].compareTo(thatArray[j])==-1))){
                mergeResult.resultIndex[k] = true;
                mergeResult.resultArray[k++] = thisArray[i++];
            } else if((j<thatArrayLength) && (i >= thisArrayLength-1 || (thisArray[i].compareTo(thatArray[j])==1))){
                mergeResult.resultIndex[k] = false;
                mergeResult.resultArray[k++] = thatArray[j++];
            } else {
                mergeResult.resultArray[k] = true;
                mergeResult.resultArray[k++] = thisArray[i++];
                mergeResult.resultArray[k] = false;
                mergeResult.resultArray[k++] = thatArray[j++];
            }
        }

        return mergeResult;
    }
}
