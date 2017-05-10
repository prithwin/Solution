package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * given a sorted Array find the k closest elements to a given number n in that List.
 * if(n > A[higest])
 *     sout A[highest -> hightest - K]
 * if(n< A[lowest])
 *      sout A[0 -> k-1]
 * else
 *      cPoint = binarySeachCpoint(A);
 *      while(!kElement collected){
 *          i = cPoint - 1;
 *          j = cPoint + 1;
 *          ldiff = ABS(A[i] - n);
 *          rDiff = ABS(A[j] - n);
 *          if(lDiff < rDiff) {
 *              sout A[j--];
 *          } else {
 *              sout A[i++]
 *          }
 *      }
 *
 */
public class KClosestElements {
    public List<Integer> findKClosestElements(List<Integer> target , int k ,int value){
        List<Integer> response = new ArrayList<>();
        if( value > target.get(target.size()-1)){
            int i = 1;
            while(i <= k){
                response.add(target.get(target.size()-(i++)));
            }
        } else if(value < target.get(0)){
            int i = 0;
            while(i < k) {
                response.add(target.get(i++));
            }
        } else {
            int crosssOverpoint = RandomDnQ.binarySearchforCrossOverPoint(target, value);
            for(int i=crosssOverpoint, j=crosssOverpoint;response.size()<4;){
                if(i==crosssOverpoint || j==crosssOverpoint){
                    i--;j++;
                    continue;
                }
                if(j > target.size() && i >=0 ){
                    response.add(target.get(i--));
                    continue;
                } else if(i < 0 && j <= target.size()-1){
                    response.add(target.get(j++));
                    continue;
                } else {
                    int ldiff = Math.abs(value-target.get(i));
                    int rdiff = Math.abs(value-target.get(j));
                    if(ldiff<=rdiff){
                        response.add(target.get(i--));
                    } else {
                        response.add(target.get(j++));
                    }
                }

            }
        }
        return response;
    }
}
