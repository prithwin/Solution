package com.personal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by prith on 02-06-2017.
 */
public class NormalizePath {
    public String normazlie(String path) {
        String[] components = path.split("/");
        List<String> result = new ArrayList<>();
        for(int i = 1 ; i < components.length ; i++) {
            if(components[i].equals("..")){
                result.remove(result.size() - 1);
            } else if(components[i].matches("[a-zA-Z0-9]+")) {
                result.add(components[i]);
            } else {
                //do nothing
            }
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append("/");
        result.stream().forEach((s) -> buffer.append(s).append("/"));
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
    }
}
