package com.personal;

import com.personal.dynamicprogramming.BinomialCoefficient;

/**
 * Created by prajeeva on 7/3/17.
 */
public class DividesByTree {
    public int getNumber(int[] target) {
        int[] C = {0, 0, 0};

        // Increment group with specified remainder
        for (int i = 0; i < target.length; ++i)
            ++C[target[i] % 3];

        // Return groups using the formula
        int a = C[0]; //completely divisible by three
        int b = C[1]; //leaves a reminder of 1
        int c = C[2]; //leaves a reminder of 2
        BinomialCoefficient bc = new BinomialCoefficient();
        int total = 0;

        total += bc.C(a,2);
        total += bc.C(a,3);
        total += bc.C(b,3) + bc.C(c,3);

        total += bc.C(b,1) * bc.C(c , 1);
        total += bc.C(a,1) * bc.C(b,1) * bc.C(c , 1);
        return total;
    }
}
