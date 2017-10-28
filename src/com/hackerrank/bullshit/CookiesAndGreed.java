package com.hackerrank.bullshit;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by prajeeva on 10/26/17.
 */
public class CookiesAndGreed {
    public int findContentChildren(Integer[] g, Integer[] s) {
        List<Integer> G = Arrays.asList(g);
        List<Integer> S = Arrays.asList(s);
        Collections.sort(G);
        Collections.sort(S);
        int i = 0 ;
        int j = 0;
        while(i < G.size() && j < S.size()) {
            if(G.get(i) <= S.get(j)) {i++;j++;}
            else {
                j++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        Object a = (Object) new ArrayList<>();
        ArrayList b = (ArrayList) new Object();
    }
}
