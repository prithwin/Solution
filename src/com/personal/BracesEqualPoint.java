package com.personal;

/**
 * Created by pr250155 on 4/12/17.
 */
public class BracesEqualPoint {

    public int findEqualPoint(String expression){
        int leftOpenBraces = 1;
        int rightCloseBraces = 0;
        for(int i=1, j=expression.length()-1 ; ; i++,j--){
            if(expression.charAt(0)=='(') leftOpenBraces++;
            if(expression.charAt(j)==')') rightCloseBraces++;
            if(j<=i || leftOpenBraces == rightCloseBraces){
                break;
            }
        }
        return leftOpenBraces;
    }

    public static void main(String[] args) {
        System.out.println(new BracesEqualPoint().findEqualPoint("(()))(()()())))"));
        System.out.println(new BracesEqualPoint().findEqualPoint("(())))("));
    }
}
