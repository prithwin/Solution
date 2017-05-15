package com.personal;

import com.personal.util.MergeResult;
import com.personal.util.Merger;
import com.personal.util.RandomDnQ;

/**
 * Created by pr250155 on 4/2/17.
 * Q: given a sorted array of and a sum X find the pair in the Array whose Sum is X
 */
public class SortedArrrayPairSum {
    public static void main(String[] args) {
        int[] target = {10, 22, 28, 29, 30, 40};
        int sum = 10;
        findAbsolutePair(target,sum);
        findClosestPair(target,sum);
        Integer[] thisArray = {5,20,30,40,50,60,70,80};
        Integer[] thatArray = {5,15,25,35,45};
//        Integer[] thisArray = {1, 4, 5, 7};
//        Integer[] thatArray = {10, 20, 30, 40};
        findClosestPairTwoArrays(thisArray, thatArray,sum);
    }

    public static void findClosestPairTwoArrays(Integer[] thisArray, Integer[] thatArray,int sum){
        MergeResult<Integer> mergeResult = new Merger<Integer>().merge(thisArray, thatArray);
        findClosestPairSourceAware(mergeResult.resultArray, mergeResult.resultIndex,sum);
    }

    private static void findClosestPairSourceAware(Object[] resultArray, Boolean[] resultIndex, int sum) {
        int closest = Integer.MAX_VALUE;
        int thizz = 0;
        int that = 0;
        for(int i = 0, j = resultArray.length-1 ; i < j ;){
           if(resultIndex[i] != resultIndex[j]){
               Integer fromThiz = (Integer) resultArray[i];
               Integer fromthat = (Integer) resultArray[j];
               int diff = sum - (fromThiz + fromthat);
               int absdiff = Math.abs(diff);
               if(absdiff<closest){
                   closest = absdiff;
                   thizz = fromThiz;
                   that = fromthat;
               }
               if(diff == 0){
                   break;
               } else if(diff > 0){
                   i++;
               } else {
                   j--;
               }
           } else {
              i++;
           }

        }

        System.out.printf("\nthe closest pair is %d and %d where the sum is %d",thizz,that,(thizz + that));
    }

    private static void findClosestPair(int[] target,int sum) {
        int thizz = 0;
        int dat = 0;
        int close = Integer.MAX_VALUE;
        for(int i=0, j = target.length-1; i<j;){
            int currentSum = target[i] + target[j];
            int diff = sum - currentSum;
            int absDiff = Math.abs(diff);
            if(absDiff < close) {
                close = absDiff;
                thizz = target[i];
                dat = target[j];
            }
            if(diff == 0){
                //you have found it
                break;
            } else if(diff > 0 ){
                //means your current sum did not exceed your target sum
                i++;
            } else {
                j--;
            }
        }

        System.out.printf("\nthe value is %d and %d",thizz,dat);

    }

    private static void findAbsolutePair(int[] target,int sum) {
        boolean found = false;
        for (int i = 0; i < target.length; i++) {
            int thiz = target[i];
            int dat = sum - thiz;
            if(dat==thiz) {
            } else if(dat>thiz){
                if(RandomDnQ.binarySearchInternal(target, i + 1, target.length - 1, dat)) {
                    System.out.printf("the combination is %d and %d", thiz, dat);
                    found=true;
                    break;
                }
            } else {
                if(RandomDnQ.binarySearchInternal(target,0,i-1,dat)) {
                    System.out.printf("the combination is %d and %d", thiz, dat);
                    found=true;
                    break;
                }
            }
        }
        if(!found){
            System.out.printf("this combination doesn't exist");
        }
    }
}

