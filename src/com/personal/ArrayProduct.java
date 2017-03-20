package com.personal;

import com.personal.util.LinkedList;

/**
 * Created by prajeev on 20/3/17.
 */
public class ArrayProduct {
    public int[] computeProductArray(int[] target){
        int[] productArray = new int[target.length];
        int grossProduct = 1;
        int nonZeroProduct = 1;
        int nonZeroNumbers = 0;

        for (int i = 0,j = target.length-1; i < target.length; i++,j--) {
            if(i<j){
                if(target[i]!=0 && target[j]!=0) {
                    grossProduct = grossProduct * target[i] * target[j];
                    nonZeroProduct = nonZeroProduct * target[i] * target[j];
                } else {
                    grossProduct = 0;
                    if(nonZeroNumbers > 1 || (target[i]==0 && target[j]==0)){
                        return productArray;
                    }
                    if(target[i]==0 && target[j]!=0){
                        nonZeroProduct = nonZeroProduct*target[j];
                        nonZeroNumbers++;
                    } else if(target[i]!=0 && target[j]==0){
                        nonZeroProduct = nonZeroProduct*target[i];
                        nonZeroNumbers++;
                    }
                }
            } else {
                if(grossProduct == 0){
                    if(target[i]!=0) {
                        productArray[i] = 0;
                    }else {
                        productArray[i] = nonZeroProduct;
                    }

                    if(target[j]!=0) {
                        productArray[j] = 0;
                    }else {
                        productArray[j] = nonZeroProduct;
                    }

                } else {
                    productArray[i] = grossProduct / target[i];
                    productArray[j] = grossProduct / target[j];
                }


            }
        }
        return productArray;
    }

    public static void main(String[] args) {
        int[] target = {1,1,1,1,1,1,1,2,1};
        System.out.println(new LinkedList(target));
        int[] result = new ArrayProduct().computeProductArray(target);
        System.out.println(new LinkedList(result));
    }
}
