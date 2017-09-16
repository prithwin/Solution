package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 3/22/17.
 */
public class MaxSumContiguousSubarray {

    public void maxSumContiguousSubArray(int[] target , int size){
        int initialSum = 0;
        int currentMax = 0;
        int lastFrameSum = 0;
        int maxFrameX = 0;
        int maxFrameY = 0;
        for(int i = 0, j = 0 ; j < target.length ;){
            int newFrameSum = 0;
            if(j<=size-1){
                //j is not completely initialized
                initialSum += target[j];
                j++;
                newFrameSum = initialSum;
                currentMax = newFrameSum;
                lastFrameSum = newFrameSum;
                maxFrameX = i;
                maxFrameY = j;
            } else {
                //now we have the frame ready to move So well move it computing the sum
                i++;
                j++;
                newFrameSum = lastFrameSum - target[i-1] + target[j-1];
                lastFrameSum = newFrameSum;
                if(newFrameSum > currentMax){
                    currentMax = newFrameSum;
                    maxFrameX = i;
                    maxFrameY = j;
                }
            }

        }
        System.out.print("the max value is: "+currentMax+" with the combination: ");
        for(int i = maxFrameX ; i<maxFrameY ; i++){
            System.out.print(target[i]+((i==maxFrameY-1)?"":" , "));
        }
    }
    public static void main(String[] args) {
        int[] target = {1,2,-3,4,5};
        int MAX_SIZE=5;
        new MaxSumContiguousSubarray().maxSumContiguousSubArray(target,MAX_SIZE);
        new MaxSumContiguousSubarray().maxSumContiguousSubArray(target);

    }


    public boolean canPermutePalindrome(String s) {
        Map<Character ,Integer> reg = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(reg.containsKey(s.charAt(i))) {
                reg.put(s.charAt(i) , reg.get(s.charAt(i)));
            } else {
                reg.put(s.charAt(i) , 1);
            }
        }
        if(s.length() % 2 == 0 ){
            if(reg.values().stream().filter(x -> x%2!=0).count() > 0) return false;
            return true;
        } else {
            if(reg.values().stream().filter(x -> x%2!=0).count() != 1) return false;
            return true;
        }
    }

    public void maxSumContiguousSubArray(int[] target) {
        int maxAtPoint = 0 ;
        int maxStartPoint=0;
        int maxEndPoint=0;
        int maxSoFar = Integer.MIN_VALUE;
        for(int i = 0 ; i < target.length ; i++){
            maxAtPoint += target[i];
            if(maxAtPoint > maxSoFar){
                maxSoFar = maxAtPoint;
                maxEndPoint = i;
            }

            if(maxSoFar < 0 ){
                maxAtPoint = 0;
                maxStartPoint=i+1;
            }

        }
        System.out.printf("\nthe max Sum contiguous Sub-array is %d with the combination: ",maxSoFar);
        for(int i = maxStartPoint ; i<=maxEndPoint ; i++){
            System.out.print(target[i]+((i==maxEndPoint)?"":" , "));
        }
    }


}
