package com.personal.dynamicprogramming;

/**
 * Created by prajeeva on 7/29/17.
 */
public class SquarePaperCutting {
    public int cut(int length, int width) {
        if(length == width) return 1;
        int minL = Integer.MAX_VALUE, minW = Integer.MAX_VALUE;
        for(int k = 1 ; k <= length / 2  ; k++) {
            minL = Math.min(minL ,cut( k , width) + cut(length - k , width));
        }
        for(int k = 1 ; k <= width / 2  ; k++) {
            minW = Math.min(minW , cut( length , k) + cut(length , width - k ));
        }
        return Math.min(minL , minW);
    }

    public int cutSQ(int length , int width) {
        if(length < 1 || width < 1) return 0;
        if(length == width) return 1;
        if(length > width) {
            int temp = length;
            length = width;
            width = temp;
        }
        int n = width/length;
        int rem = width % length;
        int min = Integer.MAX_VALUE;
        int minRem = cutSQ(length , rem);
        for (int i = 0 ; i <=length /2 ; i++) {
            for(int j = 0 ; j <= length /2 ; j++) {
                for(int k = 1 ; k < length - i && k< length - j ; k++) {
                    min = Math.min(min , cutSQ(length,j)+
                    cutSQ(i, length - j) +
                    cutSQ(k , k) +
                    cutSQ(length - (i+k), length - j) +
                    cutSQ(k , length - (k+j))
                    );
                }
            }
        }
        if(n * min + minRem < 0) {
            System.out.printf("\nfor %d * %d answer is negative ",length,width);
        }
        return n * min + minRem;
    }

    public int cutDynamic(int length , int width) {
        int[][] r = new int[length + 1][width + 1];
        for(int  l = 0 ; l < r.length ; l++) {
            for(int w = 0 ; w < r[l].length; w++) {
                if(l == 0 || w == 0) {r[l][w] = 0; continue;}
                if(l == w) {r[l][w] = 1; continue;}
                int minL = Integer.MAX_VALUE, minW = Integer.MAX_VALUE;
                for(int k = 1 ; k <= l / 2  ; k++) {
                    minL = Math.min(minL ,r[k][w] + r[l - k ][ w]);
                }
                for(int k = 1 ; k <= w / 2  ; k++) {
                    minW = Math.min(minW , r[l][k] + r[l ][w - k]);
                }
                r[l][w] = Math.min(minL ,minW);
            }
        }
        return r[length][width];
    }
}
