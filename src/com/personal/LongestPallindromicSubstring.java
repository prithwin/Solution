package com.personal;

/**
 * Created by prajeev on 13/3/17.
 */
public class LongestPallindromicSubstring {
    int gmax = Integer.MIN_VALUE;
    int ps = -1;
    int pe = -1;

    public String find(String s) {
        for(int i = 0 ; i < s.length() ; i++) {
            process(s, i , i+1);
            process(s, i , i);
        }
        return s.substring(ps,pe+1);

    }

    private void process(String s, int k , int j) {
            int len = 0;
            while(k >= 0 && j<s.length()) {
                if(s.charAt(k) == s.charAt(j)) {
                    len+=2;
                    if(len > gmax){
                        gmax =  len;
                        ps = k; pe = j;
                    }
                    k--;j++;
                } else break;
            }
    }
}
