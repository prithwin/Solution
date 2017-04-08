package com.personal;

import com.personal.util.Dictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 4/7/17.
 */
public class KFrequentWords {
    public static void main(String[] args) {
        String target = "platina topper topaz platina sdjfj jsdfj sjefj jsiefjjsd platina iefjjs jsjdfj topper " +
                "topper topaz topper topper platina topaz prithwin prithwin prithwin prithwin prithwin prithwin prithwin platina platina" +
                " platina platina";
        Map<String, Integer> podium = new HashMap<>();
        Dictionary dictionary = new Dictionary();
        for(String word : target.split(" ")){
            int currentCount = dictionary.countingInsert(word);
            leaderBoardTally(podium,word,currentCount);
        }
        System.out.println(podium);
    }

    private static void leaderBoardTally(Map<String, Integer> podium, String word, int currentCount) {
        if(podium.size() == 3){
            //podium we have to compare and replace
            if(podium.containsKey(word)){
                podium.put(word,currentCount);
                return;
            }
            String lesser = "";
            for(String leader : podium.keySet()){
                if(podium.get(leader) < currentCount){
                    lesser = leader;
                }
            }
            if(!lesser.equals("")) {
                podium.remove(lesser);
                podium.put(word, currentCount);
            }

        } else {
            podium.put(word,currentCount);
        }

    }
}
