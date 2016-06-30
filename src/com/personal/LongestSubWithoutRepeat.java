package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 1/19/16.
 */
public class LongestSubWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        //try bruteforce
        int maxFound=0;

        char[] chars = s.toCharArray();
        List<Character> uniqueChars = new ArrayList<Character>();
        for(int i = 0 ; i < s.length() ;i++){
            int newMaxFound=0;
            for(int j = i ; j < s.length();j++){
                if(!uniqueChars.contains(chars[j])){
                    uniqueChars.add(chars[j]);
                    newMaxFound++;
                }else{
                    //end of the road for this string

                    break;
                }

            }
            uniqueChars.clear();
            if(newMaxFound>maxFound){
                maxFound = newMaxFound;
            }


        }
        return maxFound;
    }

    public static void main(String[] args){
        new LongestSubWithoutRepeat().lengthOfLongestSubstring("c");
    }
}
