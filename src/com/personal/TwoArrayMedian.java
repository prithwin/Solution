package com.personal;

/**
 * Created by pr250155 on 1/21/16.
 */
public class TwoArrayMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //first figure out how to merge to sorted arrays
        int currentCheckIndex1=0;
        int currentCheckIndex2=0;
        int currentOutputIndex=0;
        double[] merger = new double[nums1.length+nums2.length];

        while(true){
           if(currentCheckIndex1==nums1.length && currentCheckIndex2<nums2.length){
               //overflow in nums1
               merger[currentOutputIndex] = nums2[currentCheckIndex2];
               currentOutputIndex++;
               currentCheckIndex2++;
           } else if(currentCheckIndex1<nums1.length && currentCheckIndex2==nums2.length) {
               //overflow in nums2
               merger[currentOutputIndex] = nums1[currentCheckIndex1];
               currentOutputIndex++;
               currentCheckIndex1++;
           } else if(currentCheckIndex1<nums1.length && currentCheckIndex2<nums2.length){
               //underflow condition.
               if(nums1[currentCheckIndex1] <= nums2[currentCheckIndex2]){
                   merger[currentOutputIndex] = nums1[currentCheckIndex1];
                   currentCheckIndex1++;
                   currentOutputIndex++;
               } else {
                   merger[currentOutputIndex] = nums2[currentCheckIndex2];
                   currentCheckIndex2++;
                   currentOutputIndex++;
               }
           } else {

               if(merger.length %2==0){
                   //ever number of items
                  return (merger[merger.length/2] + merger[(merger.length/2)-1])/2;
               } else {
                   //odd number of items
                   return  merger[(merger.length-1)/2];
               }
           }
        }
    }

    public static void main (String[] args){
        int[] a ={};
        int[] b ={2,3};
        System.out.println(new TwoArrayMedian().findMedianSortedArrays(a,b));

    }
}
