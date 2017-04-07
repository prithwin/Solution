package com.personal.util;

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
}
