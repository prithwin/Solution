package com.personal;

/**
 * Created by prajeeva on 8/2/17.
 */
public class NthPermutation {
    public String getPermutation(int n, int k) {
        if(n < 1) {return "";}
        if(n == 1) {return "1";}
        if(k > factorial(n)) {return "";}
        NextPermutation np = new NextPermutation();
        int[] target = new int[n];
        for(int i = 0 ; i< target.length ; i++) {
            target[i] = i+1;
        }
        int m = 1;
        while(m < k) {
            np.nextPermutation(target);
            m++;
        }
        StringBuilder builder = new StringBuilder();
        for(int i : target) {
            builder.append(i);
        }
        return builder.toString();
    }

    private int factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
}
