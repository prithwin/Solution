package com.personal;

/**
 * Created by pr250155 on 4/2/17.
 */
public class SortedArrayUnionIntersection {
    public int[] union(int[] a , int[] b){
        int[] union = new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(i < a.length || j < b.length){
            if(j==b.length || (i<a.length && a[i] < b[j])){
                union[k++] = a[i++];
            } else if(i == a.length || (j<b.length && b[j]< a[i])){
                union[k++] = b[j++];
            } else {
                union[k++] = b[j++];
                union[k++] = a[i++];
            }
        }
        return union;
    }

    public static void main(String[] args) {
        int[] a = {1,80,100,200,300};
        int[] b = {5,80,150,80,250,350,350,350};
        int[] result = new SortedArrayUnionIntersection().union(a, b);
        System.out.println("cjecl");
     }
}
