package com.personal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by pr250155 on 4/11/17.
 * addSpaces(target,cIndex,builder) {
 *  if(cIndex = target.length) {
 *      sout >> builder;
 *  }
 *  builder.append(target.cindex+1);
 *  addSapaces(target,cindex+1,builder);
 *  builder.remove(1);
 *
 *  builder.append(target.cindex+SPACE+1)
 *  addSpaces(target,cindex+1,builder);
 *  builder.remove(2);
 *
 *
 * }
 */
public class InsertSpaces {

    public static final String SPACE = " ";

    public List<String> insertSpaces(String target){
        List<String> result = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        builder.append(target.charAt(0));
        insertSpacesInternal(target, 1 ,"" +target.charAt(0),result);
        System.out.println(result);
        return result;
    }

    private void insertSpacesInternal(String target, int i,String in,List<String> result)  {
        if(i == target.length()){
            result.add(in);
            return;
        }
        String one = in + target.charAt(i);
        insertSpacesInternal(target, i + 1, one,result);

        String two = in + " "+  target.charAt(i);
        insertSpacesInternal(target, i + 1, two,result);
    }
}
