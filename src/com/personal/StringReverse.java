package com.personal;

import java.util.Objects;

/**
 * Created by pr250155 on 3/25/17.
 */
public class StringReverse {
    public String reverse(String input){
        if(input == null || input.equals("")){
            return "";
        }
        return input.charAt(input.length()-1)+ reverse(input.substring(0,input.length()-1));
    }

    /**
     * newer much more concise algorithm.
     * @param input
     * @return
     */
    public String reverse2(String input){
        StringBuilder builder = new StringBuilder();
        realReverse2(input,builder,0);
        return builder.toString();
    }

    private void realReverse2(String input, StringBuilder builder, int character) {
        if(character > input.length()-1){
            return;
        }
        realReverse2(input, builder, ++character);
        builder.append(input.charAt(character - 1));
    }

    public static void main(String[] args) {
        //System.out.println(new StringReverse().reverse("abcd"));
        System.out.println(new StringReverse().reverse2("abcd"));
    }
}

