package com.personal;

import java.util.*;

/**
 * Created by prajeev on 15/7/16.
 */
public class PrintParantheses {

    public static void generate(String remainderString, String set,Set<String> resultSet) {

        if (remainderString.length() == 1) {
            if (valid(set + remainderString)) {
                resultSet.add(set+remainderString);
            }
            return;
        }

        char[] charArray = remainderString.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            String reminderWithoutlead = getRemainderString(i, charArray);
            generate(reminderWithoutlead, set + charArray[i],resultSet);
        }
    }

    private static boolean valid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push(c);
            } else {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> resultSet = new HashSet<>();
        generate(getInitialSetByNumber(6), "",resultSet);
        for (String s : resultSet){
            System.out.println(s);
        }
    }

    private static String getInitialSetByNumber(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1; i<=(n*2) ;i++){
            if(i<=n){
                stringBuilder.append("{");
            } else {
              stringBuilder.append("}");
            }
        }
        return stringBuilder.toString();
    }

    private static String getRemainderString(int i, char[] charArray) {
        StringBuilder output = new StringBuilder();
        for (int j = 0; j < i; j++) {
            output.append(charArray[j]);
        }
        //add all the ones after i
        for (int j = i + 1; j < charArray.length; j++) {
            output.append(charArray[j]);
        }

        return output.toString();
    }
}
