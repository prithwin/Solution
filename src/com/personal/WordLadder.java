package com.personal;

import java.util.*;

/**
 * Created by prajeeva on 9/15/17.
 */
public class WordLadder {
    private static class WordGraph {
        String word;
        List<WordGraph> con = new ArrayList<>();

        WordGraph(String word) {
            this.word = word;
        }

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        WordGraph g = new WordGraph(beginWord);
        g.word = beginWord;
        Map<String,WordGraph> visited = new HashMap<>();
        createWordGraph(endWord , wordList , g,visited);
        System.out.println("Test");
        return 0;
    }

    private void createWordGraph(String endWord, List<String> wordList, WordGraph g ,Map<String , WordGraph> visited) {
        if(g.word.equals("dog")) {
            System.out.println("hold");
        }
            visited.put(g.word , g);
            System.out.println(String.format("==========%s===========", g.word));
            for (int i = 0; i < g.word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String nw = g.word.substring(0, i) + c + g.word.substring(i + 1, g.word.length());
                    if(nw.equals("cog")) {
                        System.out.println("hold");
                    }
                    if (!nw.equals(g.word)) {
                        if (wordList.contains(nw) && !visited.containsKey(nw)) {
                            WordGraph w = new WordGraph(nw);
                            g.con.add(w);
                        } else if(visited.containsKey(nw)) {
                            g.con.add(visited.get(nw));
                        }

                    }

                }
            }
            for (WordGraph gD : g.con) {
                if(!visited.containsKey(gD.word)) {
                    createWordGraph(endWord, wordList, gD, visited);
                }
            }
    }

}
