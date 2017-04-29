package com.personal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by pr250155 on 4/11/17.
 */
public class InsertSpaces {

    public static final String SPACE = " ";

    public List<String> insertSpaces(String target){
        List<String> result = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        builder.append(target.charAt(0));
        insertSpacesInternal(target, 1,builder,result);
        System.out.println(result);
        return result;
    }

    private void insertSpacesInternal(String target, int stringIndex,StringBuilder builder,List<String> result)  {
        if(stringIndex == target.length()){
            result.add(builder.toString());
            return;
        }
        builder.append(target.charAt(stringIndex));
        insertSpacesInternal(target, stringIndex + 1, builder,result);
        builder.delete(builder.length()-1,builder.length());

        builder.append(SPACE).append(target.charAt(stringIndex));
        insertSpacesInternal(target, stringIndex + 1, builder,result);
        builder.delete(builder.length()-2,builder.length());
    }

    public static void main(String[] args) {
        new InsertSpaces().insertSpaces("ABCD");
    }
}
