package com.personal;

import com.personal.util.ComparableNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 4/16/17.
 */
public class CheckStringAnagram {

    private static boolean isAnagram = true;

    public boolean isAnagram(String thiz, String dat) {
        Map<Character,ComparableNumber> characterMap = new HashMap<>();
        for(int i = 0 ; i < thiz.length() ; i++){
            if(characterMap.containsKey(thiz.charAt(i))){
                characterMap.get(thiz.charAt(i)).number = characterMap.get(thiz.charAt(i)).number+1;
            } else {
                characterMap.put(thiz.charAt(i),new ComparableNumber(1));
            }
        }

        for(int i = 0 ; i < dat.length() ; i++){
            if(characterMap.containsKey(dat.charAt(i))){
                characterMap.get(dat.charAt(i)).number = characterMap.get(dat.charAt(i)).number-1;
            } else {
                isAnagram = false;
                break;
            }
        }

        if(!isAnagram){
            return false;
        } else {
            characterMap.keySet().stream().forEach((k) -> {if(characterMap.get(k).number != 0){
                isAnagram = false;}});
            try {
                return isAnagram;
            }finally {
                isAnagram=true;
            }
        }

    }
}
