package com.personal;

/**
 * Created by pr250155 on 3/27/17.
 */
public class RandomDnQ {
    public static int countInArray(int[] target,int start, int end,int item){
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
    
    public static boolean binarySearch(int[] target, int item){
        return binarySearchInternal(target,0,target.length-1,item);
    }

    public static boolean binarySearchInternal(int[] target,int start, int end, int item){
        if(start>end){
            return false;
        }
        if(start == end){
            if(target[start] == item){
                return true;
            }
            return false;
        }
        int mid = start + ((end-start)/2);
        if(item == target[mid]){
            return true;
        }
        if(item > target[mid]){
            return binarySearchInternal(target,mid+1,end,item);
        } else {
            return binarySearchInternal(target,start,mid-1,item);
        }
    }



    public static void main(String[] args) {
        int[] target = {1,2,3,4,5,6,4,3,6,3,3,3,7,8,9,10,3};
        System.out.println(countInArray(target,0, target.length-1,3));
        int[] searchTarget = {1,2,3,4,5,6,7,8,9,54};
        System.out.println(binarySearch(searchTarget,1));
        System.out.println(binarySearch(searchTarget,2));
        System.out.println(binarySearch(searchTarget,3));
        System.out.println(binarySearch(searchTarget,4));
        System.out.println(binarySearch(searchTarget,0));
        System.out.println(binarySearch(searchTarget,54));
    }
}
