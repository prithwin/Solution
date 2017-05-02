package com.personal;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 5/2/17.
 */
public class HornersPolynomial {

    public int compute(List<Integer> coefficients,int x) {
        int n = coefficients.size() - 1;
        while(n>=0) {
            for (int i = 0; i < n; i++) {
                coefficients.set(i, coefficients.get(i) * x);
            }
            n--;
        }
        return coefficients.stream().reduce((a,b) -> a+b).get();
    }

    public static void main(String[] args) {
        System.out.print(new HornersPolynomial().compute(Arrays.asList(2,-1,3,1,-5),3));
    }
}
