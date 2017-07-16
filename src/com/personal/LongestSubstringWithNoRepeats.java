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

    public int lengthOfLongestSubstring(String target) {
      if(target.length() <= 1) return target.length();

      Map<Character , Integer> registry = new HashMap<>();
      int start = 0 , end = 0 ;
      int max = 0;

      while(end < target.length()) {
          if(registry.containsKey(target.charAt(end))) {
              start = Math.max(start, registry.get(target.charAt(end)) + 1);
          }
          registry.put(target.charAt(end), end);
          max = Math.max(max , end - start + 1);
          end++;
      }
      return max;

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
        System.out.println(new LongestSubstringWithNoRepeats().lengthOfLongestSubstring("abcabcbb"));
    }
}
