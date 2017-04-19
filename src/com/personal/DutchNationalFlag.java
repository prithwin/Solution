package com.personal;

import java.util.Arrays;

/**
 * Created by pr250155 on 4/19/17.
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
//        int[] target = {0,0,0,0,1,1,0,1,2,2,1,1,0,1,2,2,0,1,2,0,0,2,1,0,2,1,0,2,2,0,1};
        int[] target = {0,1,2};
        new DutchNationalFlag().threeWayPartition(target);
       for(int item : target){
           System.out.println(item);
       }
    }

    public void threeWayPartition(int[] target){

        for(int i = 0,j = target.length-1 , k = 0, l = target.length-1 ; i < target.length && j >=0 ; ){
            if(i<=j){
                if(target[i] == 1 && target[j]==0) {
                    int temp = target[i];
                    target[i] =  target[j];
                    target[j] = temp;
                    i++;j--;
                }
                else if(target[i] == 1 && target[j]!=0){
                    j--;
                }
                else if(target[i] != 1 && target[j]==0){
                    i++;
                } else {
                    i++;j--;
                }

            } else {
                polarizeArray(target,k,j,0,2);
                polarizeArray(target,i,l,2,1);
                i=target.length;
                j=-1;
            }

        }
    }

    private void polarizeArray(int[] target, int start, int end,int left, int right) {
        for ( int i = start , j = end  ; j>i ; ) {
            if(target[i]==right && target[j]==left){
                int temp = target[i];
                target[i] = target[j];
                target[j] = temp; i++;j--;
            } else if(target[i]==right && target[j]!=left) {
                j--;
            } else if(target[i]!=right && target[j]==left){
                i++;
            } else {
                i++;j--;
            }
        }
    }

}
