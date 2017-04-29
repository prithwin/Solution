package com.personal;

import java.util.Map;
import java.util.HashMap;
/**
 * Created by pr250155 on 4/28/17.
 */
public class LongestSubstringWithNoRepeats {

    public String longestSubstringWithNoRepeats(String target) {
        Map<Character,Integer> registry = new HashMap();
        StringBuilder returnString = new StringBuilder();
        String longestStringObserved = "";

        for( char c : target.toCharArray() ) {
            if(shouldReset(c,registry)) {
                registry.clear();
                returnString = new StringBuilder();
            } else {
                returnString.append(c);
            }
            if(returnString.length() > longestStringObserved.length()){
                longestStringObserved = returnString.toString();
            }
        }
        return longestStringObserved;
    }

    private boolean shouldReset(char c,Map<Character,Integer> registery) {
        if(registery.containsKey(c)){
            return true;
        } else {
            registery.put(c,1);
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithNoRepeats().longestSubstringWithNoRepeats("GEEKSFORGEEKS"));
    }
}
