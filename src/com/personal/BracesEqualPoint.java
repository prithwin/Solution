package com.personal;

import com.personal.util.ArrayToListConverter;

/**
 * Created by pr250155 on 4/12/17.
 */
public class BracesEqualPoint {

    public int findEqualPoint(String expression){
        int[] opening = new int[expression.length()];
        int[] closing = new int[expression.length()];
        int leftOpenBraces = 0 , rightCloseBraces = 0;
        for(int i=1, j=expression.length()-1 ; ; i++,j--){
            if(i==expression.length()) {break;}
            if(expression.charAt(i)=='(') {opening[i] = leftOpenBraces++;} else {opening[i] = leftOpenBraces;}
            if(expression.charAt(j)==')') {closing[j] = rightCloseBraces++;} else {closing[j] = rightCloseBraces;}
        }
        for(int i = 1 ; i < expression.length() ; i++){
            if(opening[i] == closing[i]){
                return i;
            }
        }
        return 0;
    }
}
