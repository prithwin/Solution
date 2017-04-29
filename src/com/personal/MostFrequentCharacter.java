package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 4/26/17.
 */
public class MostFrequentCharacter {

    class Answer {
        char item;
        int multiplicity = Integer.MIN_VALUE;
    }

    Map<Character,Integer> index = new HashMap<>();

    public Answer findMostFrequentChar(String target) {
        Answer answer = new Answer();
        char[] targetArray = target.toCharArray();
        for(char c : targetArray) {
            if(index.containsKey(c)) {
                int count = index.get(c);
                index.put(c,count+1);
                if(count+1 > answer.multiplicity){
                    answer.multiplicity = count + 1;
                    answer.item = c;
                }
            } else {
                index.put(c,1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Answer answer = new MostFrequentCharacter().findMostFrequentChar("AAAAAAABBBBBBBBBBcccAAAAAAADDD");
        System.out.printf("the most frequent Character is %c which appears %d times",answer.item,answer.multiplicity);
    }
}
