package com.personal.util;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by pr250155 on 4/7/17.
 */
public class Dictionary {
    DictionaryNode dictionaryRoot = new DictionaryNode();

    public void insert(String word){
        DictionaryNode trav = dictionaryRoot;
        for(Character c : word.toCharArray()){
            if(!trav.chars.containsKey(c)){
                DictionaryNode dictionaryNode = new DictionaryNode();
                trav.chars.put(c,dictionaryNode);
            }
            trav = trav.chars.get(c);
        }
        trav.wordEnd = true;
        trav.count++;
    }
    public int countingInsert(String word){
        DictionaryNode trav = dictionaryRoot;
        for(Character c : word.toCharArray()){
            if(!trav.chars.containsKey(c)){
                DictionaryNode dictionaryNode = new DictionaryNode();
                trav.chars.put(c,dictionaryNode);
            }
            trav = trav.chars.get(c);
        }
        trav.wordEnd = true;
        trav.count++;
        return trav.count;
    }

    public boolean contains(String word){
        DictionaryNode trav = dictionaryRoot;
        for(Character c : word.toCharArray()){
            if(trav.chars.containsKey(c)){
                trav = trav.chars.get(c);
            } else {
                return false;
            }
        }
        if(trav.wordEnd){
            return true;
        }
        return false;
    }

    public int getRepetitions(String word){
        DictionaryNode trav = dictionaryRoot;
        for(Character c : word.toCharArray()){
            if(trav.chars.containsKey(c)){
                trav = trav.chars.get(c);
            } else {
                return 0;
            }
        }
        if(trav.wordEnd){
            return trav.count;
        }
        return 0;
    }

    public List<String> getWordStartingFrom(String start) {
        DictionaryNode startingDictionary = this.dictionaryRoot;
        for(int i = 0 ; i < start.length() ; i++) {
            if(startingDictionary.chars.containsKey(start.charAt(i))) {
                startingDictionary = startingDictionary.chars.get(start.charAt(i));
            }
        }
        List<String> result = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        getAllWordsStartingFrom(startingDictionary,result, buffer);
        return result;
    }

    public void getAllWordsStartingFrom(DictionaryNode startNode,List<String> payload,StringBuilder builder) {
        if(startNode.chars.isEmpty()){
            return;
        }
         if(startNode.wordEnd) {
             payload.add(builder.toString());
         }
         for(char c : startNode.chars.keySet()) {
            builder.append(c);
             getAllWordsStartingFrom(startNode.chars.get(c) , payload,builder);
             builder.delete(builder.length()-1, builder.length());
         }
    }
}
