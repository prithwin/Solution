package com.hackerrank.bullshit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by prajeeva on 10/25/17.
 */
public class Triangles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] dataLine = scanner.nextLine().split("\\s");
        int[] L = new int[N];
        for(int i = 0 ; i < N ; i++) {
            L[i] = Integer.parseInt(dataLine[i]);
        }
        Arrays.sort(L);
        long max = Integer.MIN_VALUE;
        int x=0;
        int y=0;
        int z=0;
        for(int i = 2 ; i < N ; i++) {
            int a = L[i];
            int b = L[i-1];
            int c = L[i-2];
            if(a+b > c && b+c > a && c+a > b) {
                if(a + b +c > max) {
                    max = a + b + c;
                    x = a;
                    y = b;
                    z = c;
                }
            }
        }
        if(max == Integer.MIN_VALUE) {
            System.out.println(-1); return;
        }
        System.out.println(z + " " + y + " " + x);
    }

}
