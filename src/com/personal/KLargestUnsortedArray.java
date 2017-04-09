package com.personal;

/**
 * Created by pr250155 on 4/9/17.
 */
public class KLargestUnsortedArray {
    public int findKthLargestInArray(Integer target[],int k){
        quickSortKPivot(target, 0, target.length - 1, k-1,k-1);
        return target[k-1];
    }

    private void quickSortKPivot(Integer[] target, int start, int end, int pivot,int k) {
        if(end <= start){
            return;
        } else if(end - start == 1 && target[end]>target[start]){
            Integer temp = target[start];
            target[start] = target[end];
            target[end] = temp;
        } else {
            if(pivot!=k){
                pivot = start+((end - start)/2);
            }
            for(int i = start, j = end ; ;){
                while(target[i]> target[pivot] && i <=pivot){
                    i++;
                }
                while(target[j] < target[pivot] && j >= pivot){
                    j--;
                }
                Integer temp = target[i];
                target[i] = target[j];
                target[j] = temp;

                if(i==pivot){
                    pivot = j;
                    break;
                }
                if(j==pivot) {
                    pivot = i;
                    break;
                }
            }

            if(pivot!=k){
                quickSortKPivot(target,start,pivot,pivot,k);
                quickSortKPivot(target,pivot,end,pivot,k);

            } else {
                quickSortKPivot(target,start,pivot,pivot,k);
            }

        }

    }

    public static void main(String[] args) {
        Integer[] target = {5,34,7,89,677,90,12,1,3};
        new KLargestUnsortedArray().findKthLargestInArray(target,3);
    }
}
