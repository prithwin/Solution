package com.personal;

/**
 * Created by prajeev on 20/3/17.
 * basic logic: start with basic list 1,2,3,4
 * 1 -> 1,0,0,0
 * 1*1 -> 1,1,0,0
 * 1*1*2 -> 1,1,2,0
 * 1*1*2*3 -> 1,1,2,6
 *
 * you have made sure that for each element i has the product of all the elements towards the left of it.
 * now this product need to have the product of every element to the right of it
 *
 * 1,1,2,6 <- 1
 * 1,1,8,6 <- 1*4
 * 1,12,8,6 <- 1*4*3
 * 24,12,8,6 <- 1*4*3*2
 *
 */
public class ArrayProduct {

    public int[] computeProductArrayShort(int[] nums) {
        int[] result = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = temp;
            temp = temp*nums[i];
        }
        temp = 1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            result[i] = result[i]*temp;
            temp = temp*nums[i];
        }
        return result;
    }

//    private int[] computeProductArray(int[] target){
//        int[] productArray = new int[target.length];
//        int grossProduct = 1;
//        int nonZeroProduct = 1;
//        int zeroOccurences = 0;
//
//        for (int i = 0,j = target.length-1; i < target.length; i++,j--) {
//            if(i<=j){
//                if(i==j){
//                    if(target[i]==0){
//                        grossProduct = 0;
//                        productArray[i] = nonZeroProduct;
//                        zeroOccurences++;
//                    } else {
//                        productArray[i] = grossProduct;
//                        grossProduct = grossProduct*target[i];
//                        continue;
//                    }
//                }
//                if(target[i]!=0 && target[j]!=0) {
//                    grossProduct = grossProduct * target[i] * target[j];
//                    nonZeroProduct = nonZeroProduct * target[i] * target[j];
//                } else {
//                    grossProduct = 0;
//                    if(zeroOccurences > 1 || (target[i]==0 && target[j]==0)){
//                        return productArray;
//                    }
//                    if(target[i]==0 && target[j]!=0){
//                        nonZeroProduct = nonZeroProduct*target[j];
//                        zeroOccurences++;
//                    } else if(target[i]!=0 && target[j]==0){
//                        nonZeroProduct = nonZeroProduct*target[i];
//                        zeroOccurences++;
//                    }
//                }
//            } else {
//                if(zeroOccurences>1){
//                    return productArray;
//                }
//                if(grossProduct == 0){
//                    if(target[i]!=0) {
//                        productArray[i] = 0;
//                    }else {
//                        productArray[i] = nonZeroProduct;
//                    }
//
//                    if(target[j]!=0) {
//                        productArray[j] = 0;
//                    }else {
//                        productArray[j] = nonZeroProduct;
//                    }
//
//                } else {
//                    productArray[i] = grossProduct / target[i];
//                    productArray[j] = grossProduct / target[j];
//                }
//
//
//            }
//        }
//        return productArray;
//    }
}
