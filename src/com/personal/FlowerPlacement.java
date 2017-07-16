package com.personal;

/**
 * Created by prajeeva on 7/15/17.
 */
public class FlowerPlacement {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int placed = 0;
        if(n > flowerbed.length) return false;
        int start = 0;
        for(int i = 0 ; i < n ; i ++) {
            for (int j = start ; j < flowerbed.length ; j++) {
                if (flowerbed[j] == 0) {
                    if(j > 0  && j < flowerbed.length - 1) {
                        if(flowerbed[j-1] == 0 && flowerbed[j + 1] == 0) {
                            start = j+ 1;
                            flowerbed[j] = 1;
                            placed++;break;
                        }
                    }
                    if(j == 0 && j == flowerbed.length - 1 && flowerbed[j] == 0) {start = j+ 1;flowerbed[j] = 1;placed++;break;}
                    if(j == 0 && flowerbed[ j + 1] == 0) {start = j+ 1;flowerbed[j] = 1;placed++;break;}
                    if(j == flowerbed.length - 1 && flowerbed[j - 1] == 0) {start = j+ 1;flowerbed[j] = 1;placed++;break;}
                }
            }
        }
        return placed == n;
    }
}
