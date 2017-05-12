package com.personal;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/23/17.
 * TODO: not fully functional
 */
public class LongestCommonPrefix {
    public String getLongestCommonPrefix(List<String> target){
        String first = target.get(0);
        int lcpEnd = first.length() - 1;
        for(int i = 1 ; i < target.size() ; i++) {
            String subject = target.get(i);
            if(subject.length() < lcpEnd+1){
                lcpEnd = subject.length()-1;
            }
            lcpEnd = findLastMatchPoint(first,subject,0,lcpEnd);
        }
        return first.substring(0,lcpEnd);
    }

    private int findLastMatchPoint(String first, String subject,int start, int lcpEnd) {
        int mid = start + (lcpEnd - start) / 2;
        if(first.charAt(mid) != subject.charAt(mid) && first.charAt(mid - 1) != subject.charAt(mid - 1)) {
            return findLastMatchPoint(first,subject,start,mid-1);
        } else if(first.charAt(mid) == subject.charAt(mid) && first.charAt(mid - 1) == subject.charAt(mid - 1)) {
            return findLastMatchPoint(first,subject,mid +1,lcpEnd);
        } else {
            return mid;
        }
    }
}
