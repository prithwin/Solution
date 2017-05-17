package com.personal.util;

/**
 * Created by pr250155 on 3/25/17.
 */
public class CustomStringUtils {
    public String reverse(String input){
        if(input == null || input.equals("")){
            return "";
        }
        return input.charAt(input.length()-1)+ reverse(input.substring(0,input.length()-1));
    }

    /**
     * newer much more concise algorithm.
     * R(S,I,Sb) {
     *     if(i>s.length-1) return;
     *     R(S,++I,Sb);
     *     Sb.append(s.charat(i-1))
     * }
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

    public boolean checkSubstring(String original, String substring){
        if(original.length()<substring.length()){
            return false;
        }
        if(substring.length() == 0){
            return false;
        }
        if(substring.length() == 1 && original.charAt(0) == substring.charAt(0)){
            return true;
        }
        if(substring.charAt(0)==original.charAt(0)){
            return checkSubstring(original.substring(1),substring.substring(1));
        }
        return checkSubstring(original.substring(1),substring);
    }

    public static void main(String[] args) {
        //System.out.println(new StringReverse().reverse("abcd"));
//        System.out.println(new StringReverse().reverse2("abcd"));
//        System.out.println(new StringReverse().reverse2("abcd"));
        System.out.println(new CustomStringUtils().checkSubstring("jsdjfiejfsdfjprithwinsdfjiwejfdfs","z"));
    }
}

