package com.random.test;

import com.sun.deploy.util.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajeeva on 7/23/17.
 */
public class LineGenerator {
    public static void main(String[] args) {
        int N = 5000; //generate these many number of lines
        List<List<String>> optionsTable = new ArrayList<>();
        List<String> userName = new ArrayList<String>();
        userName.add("Ram");
        userName.add("Rahim");
        userName.add("Jon");
        userName.add("Bhaskar");
        userName.add("Prithwin");
        userName.add("Thrishaya");
        userName.add("Choklu");


        List<String> webPages = new ArrayList<String>();
        webPages.add("/news");
        webPages.add("/feed");
        webPages.add("/porn");
        webPages.add("/entertainment");
        webPages.add("/social");
        List<String> store = new ArrayList<>();
        for(int i  = 0 ; i< N ; i++) {
            String lineToWrite = userName.get(randomValue(0,userName.size())) + ","
                    + webPages.get(randomValue(0,webPages.size()));
            store.add(lineToWrite);
        }
        try {
            FileUtils.writeLines(new File("/Users/prajeeva/notes/sitevisits.txt" ), store);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static int randomValue(int from, int to) {
        int resposne = (int) Math.floor(Math.random() * to);
        if(resposne < from) return from;
        return resposne;
    }
}
