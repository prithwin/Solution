package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 4/30/17.
 */
public class HorspoolStringMatching {

    public boolean contains(String text,String pattern) {
        Map<Character,Integer> skipMap = buildSkipMap(pattern);
        for(int i = 0 + pattern.length() -1 ; i < text.length() ; ) {
            for (int j = pattern.length()-1, k = i ; j >= 0 ;){

                if(text.charAt(k)!=pattern.charAt(j)){
                    if(skipMap.get(text.charAt(i)) == null) {
                        i+=pattern.length();
                    } else {
                        i += skipMap.get(text.charAt(i));
                    }
                    break;
                }
                j--;k--;
                if(j==-1){
                    return true;
                }
            }
        }
        return false;
    }

    private Map<Character, Integer> buildSkipMap(String pattern) {
        Map<Character,Integer> skipMap = new HashMap<>();
        int i = 1;
        for(char c : pattern.toCharArray()){
            skipMap.put(c , pattern.length() - i++ );
        }
        return skipMap;
    }

    public static void main(String[] args) {
        System.out.println(new HorspoolStringMatching().contains("THIS IS THE TARGET", "ARGE"));
    }
}
