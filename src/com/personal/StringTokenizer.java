package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 5/25/17.
 */
public class StringTokenizer {
    public List<String> tokenizeString(String target,char del) {
        List<String> output = new ArrayList<>();
        int i=0,j=0;
        while(i < target.length()) {
            if(target.charAt(i) != del) {
                i++;
            } else {
                String token = target.substring(j,i);
                output.add(token);
                i++;
                j=i;
            }
        }
        output.add(target.substring(j,i));
        return output;
    }
}
