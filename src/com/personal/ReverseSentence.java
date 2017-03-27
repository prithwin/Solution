package com.personal;

/**
 * Created by pr250155 on 3/27/17.
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String target = "this is what the task at hand is";
        String[] words = target.split("\\s");
        System.out.println();
        StringBuilder stringBuilder = new StringBuilder();
        for(String word : words){
            stringBuilder.append(reverse(word));
            stringBuilder.append(" ");
        }
        System.out.println(reverse(stringBuilder.toString().trim()));
    }

    private static String reverse(String target) {
        if(target == null || target.length()==0){
            return "";
        }
        return target.charAt(target.length()-1) + reverse(target.substring(0,target.length()-1));
    }
}
