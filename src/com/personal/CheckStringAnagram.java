package com.personal;

import com.personal.util.ComparableNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 4/16/17.
 */
public class CheckStringAnagram {
    public static void main(String[] args) {
        String thiz = "this i that";
        String dat = "that is this";
        boolean theyre = true;
        Map<Character,ComparableNumber> characterMap = new HashMap<>();
        for(int i = 0 ; i < thiz.length() ; i++){
            if(characterMap.containsKey(thiz.charAt(i))){
                characterMap.get(thiz.charAt(i)).number = characterMap.get(thiz.charAt(i)).number++;
            } else {
                characterMap.put(thiz.charAt(i),new ComparableNumber(0));
            }
        }

        for(int i = 0 ; i < thiz.length() ; i++){
            if(characterMap.containsKey(dat.charAt(i))){
                characterMap.get(dat.charAt(i)).number = characterMap.get(dat.charAt(i)).number--;
            } else {
                theyre = false;
                break;
            }
        }

        if(!theyre){
            System.out.println("Theyr'e not anagrams");
        } else {
            //double chec
            characterMap.keySet().stream().forEach((k) -> {if(characterMap.get(k).number > 0){
                System.out.println("They're not anagrams");}});
        }

    }
}
