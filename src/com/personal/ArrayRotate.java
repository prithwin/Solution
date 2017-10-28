package com.personal;

import java.util.Scanner;

/**
 * Created by pr250155 on 5/27/17.
 */
public class ArrayRotate {
    public void rotateLeft(int[] target, int n) {
        while(--n >= 0){
            int temp = target[0];
            for(int i = 1 ; i < target.length ; i++) {
                target[i-1] = target[i];
            }
            target[target.length - 1] = temp;
        }
        new Scanner(System.in).nextLine();
    }

    public void rotateRight(int[] target, int n) {
        while(--n >= 0) {
            int temp = target[target.length - 1];
            for(int i = target.length - 2 ; i >=0 ; i--) {
                target[i+1] = target[i];
            }
            target[0] = temp;
        }
    }
}
