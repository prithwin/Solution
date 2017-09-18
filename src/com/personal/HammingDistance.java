package com.personal;

/**
 * Created by prajeeva on 9/17/17.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        String x_b = Integer.toBinaryString(x);
        String y_b = Integer.toBinaryString(y);

        while(x_b.length() < y_b.length()) x_b = "0"+x_b;
        while(y_b.length() < x_b.length()) x_b = "0"+y_b;
        System.out.println(x_b);
        System.out.println(y_b);

        for(int i = 0 ; i < x_b.length() ; i++) {

        }
        return 0;
    }
}
