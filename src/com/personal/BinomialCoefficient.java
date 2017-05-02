package com.personal;

/**
 * Created by pr250155 on 5/2/17.
 */
public class BinomialCoefficient {
    public int C2(int n, int r){
        System.out.printf("\nConputing %dC%d",n,r);
        if(r>n){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(r == 0) {
            return 1;
        }
        return C2(n-1,r-1) + C2(n-1,r);

    }

    public int C(int n,int r) {

        int[][] computationMatrix = new int[n+1][r+1];
        for(int i = 0 ; i <= n ; i++) {
            for (int j = 0; j <= r; j++) {
                if(j > i){
                    break;
                }
                if(i==0 || j==0) {
                    computationMatrix[i][j] = 1;
                    continue;
                }
                computationMatrix[i][j] = computationMatrix[i-1][j-1] + computationMatrix[i-1][j];
            }
        }
        return computationMatrix[n][r];
    }

    public static void main(String[] args) {
        System.out.println(new BinomialCoefficient().C2(10, 3));
    }
}
