package com.personal;

/**
 * Created by pr250155 on 3/22/17.
 */
public class MaxSumContiguousSubarray {
    public static void main(String[] args) {
        int[] target = {2,4,5,22,111};
        int MAX_SIZE=1;
        int initialSum = 0;
        int currentMax = 0;
        int maxFrameX = 0;
        int maxFrameY = 0;
        for(int i = 0, j = 0 ; j < target.length -1 ;){
            int newFrameSum = 0;
            if(j<MAX_SIZE){
                //j is not completely initialized
                initialSum += target[j];
                j++;
                newFrameSum = initialSum;
            } else {
                //now we have the frame ready to move So well move it computing the sum
                i++;
                j++;
                newFrameSum = currentMax - target[i-1] + target[j];
            }
            if(newFrameSum > currentMax){
                currentMax = newFrameSum;
                maxFrameX = i;
                maxFrameY = j;
            }
        }
        System.out.println("the max value is: "+currentMax+" with the combination: ");
        for(int i = maxFrameX ; i<=maxFrameY ; i++){
            System.out.println(target[i]);
        }
    }
}
