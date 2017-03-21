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
        int zeroOccurences = 0;

        for (int i = 0,j = target.length-1; i < target.length; i++,j--) {
            if(i<=j){
                if(i==j){
                    if(target[i]==0){
                        grossProduct = 0;
                        zeroOccurences++;
                    } else {
                        productArray[i] = grossProduct;
                        grossProduct = grossProduct*target[i];
                        continue;
                    }
                }
                if(target[i]!=0 && target[j]!=0) {
                    grossProduct = grossProduct * target[i] * target[j];
                    nonZeroProduct = nonZeroProduct * target[i] * target[j];
                } else {
                    grossProduct = 0;
                    if(zeroOccurences > 1 || (target[i]==0 && target[j]==0)){
                        return productArray;
                    }
                    if(target[i]==0 && target[j]!=0){
                        nonZeroProduct = nonZeroProduct*target[j];
                        zeroOccurences++;
                    } else if(target[i]!=0 && target[j]==0){
                        nonZeroProduct = nonZeroProduct*target[i];
                        zeroOccurences++;
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
        int[] target = {6,3,7,8,2,2,4,2,7,3,9,8,0};
        System.out.println(new LinkedList(target));
        int[] result = new ArrayProduct().computeProductArray(target);
        System.out.println(new LinkedList(result));
    }
}
