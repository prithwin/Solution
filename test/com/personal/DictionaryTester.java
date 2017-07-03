package com.personal;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;
import com.personal.util.Dictionary;

import com.personal.util.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.io.*;

/**
 * Created by prith on 10-06-2017.
 */
public class DictionaryTester {
    @Test(enabled = false) public void testAddFirst500words() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("./words.txt"));
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Dictionary dictionary = new Dictionary();
        String lineRead;
       while((lineRead = bufferedReader.readLine()) != null){
            dictionary.insert(lineRead);
        }
        List<String> result = dictionary.getWordStartingFrom("mis");
        System.out.println("wait");
    }
}
