package com.personal;

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

    public static void main(String[] args) {
        System.out.println(new StringReverse().reverse("abcd"));
    }
}

