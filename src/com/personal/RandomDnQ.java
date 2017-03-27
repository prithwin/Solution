package com.personal;

/**
 * Created by pr250155 on 3/27/17.
 */
public class RandomDnQ {
    public int countInArray(int[] target,int start, int end,int item){
        if(start>end) {
            return 0;
        }

        if(start==end){
            if(target[start]==item){
                return 1;
            }
            return 0;
        }
        int mid = start+ (end-start)/2;
        return countInArray(target,start,mid,item)+ countInArray(target,mid+1,end,item);
    }

    public static void main(String[] args) {
        int[] target = {1,2,3,4,5,6,4,3,6,3,3,3,7,8,9,10,3};
        System.out.println(new RandomDnQ().countInArray(target,0, target.length-1,3));
    }
}
