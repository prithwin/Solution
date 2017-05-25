package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/25/17.
 */
public class FastCodingTest {
    @Test public void fastStringReverse() {
        long startR = System.currentTimeMillis();
        System.out.println(isPallindromeR("MalaMalaMalaMalaMalaMalaMalaMalaMalaMalaMalaMalayalaMalaMalaMalaMalaMalaMalaMalaMalaMalaMalaMalaM"));
        long endR = System.currentTimeMillis();
        System.out.println("time taken by recursive algorithm="+(endR-startR));

        long startI = System.currentTimeMillis();
        System.out.println(isPallindrome("MalaMalaMalaMalaMalaMalaMalaMalaMalaMalaMalaMalayalaMalaMalaMalaMalaMalaMalaMalaMalaMalaMalaMalaM"));
        long endI = System.currentTimeMillis();
        System.out.println("time taken by recursive algorithm="+(endI-startI));
        String test = "ABDCEFGH";
        String reverse = new String(reverseC(test.toCharArray(),0,test.length()-1));
        System.out.println(reverse);

        //check for duplicates in a string
        String target = "ABCDEFGH";
        System.out.println("does the string have a repeat char : "+isRepeatingChar(target));

        String thizz = "ABCDE";
        String that = "DECBA";
        System.out.println("are the strings Anagrams of each other: "+areTheyAnagrams(thizz,that));

        String mayBeNumber = "ABCDEFBCDEF";
        for(int i = 0 ; i < mayBeNumber.length() ; i++ ) {
            if(mayBeNumber.charAt(i)>= 48 && mayBeNumber.charAt(i) <=57) {
                System.out.println("Number found");
            }
        }

        String vc = "abcdefghijklmnopqrstuvwxyz";
        int vow = 0 , con = 0;
        List<Character> vows = Arrays.asList('a','e','i','o','u');
        for(int i = 0 ; i < vc.length() ; i++) {
            char ciq = vc.charAt(i);
            if(vows.contains(ciq)) {
                vow++;
            } else {con++;
            }

        }
        System.out.println(vow);
        System.out.println(con);

    }

    private String areTheyAnagrams(String thizz, String that) {
        if(thizz.length() != that.length()) return "NO";

        Map<Character,Integer> registry = new HashMap<>();
        for(int i = 0 ; i < thizz.length() ; i++) {
            if(registry.containsKey(thizz.charAt(i))) {
                registry.put(thizz.charAt(i) , registry.get(thizz.charAt(i) + 1));
            } else {
                registry.put(thizz.charAt(i), 1);
            }
        }

        for (int i = 0 ; i < that.length() ; i++ ) {
            if(!registry.containsKey(that.charAt(i))) {
                return "NO";
            } else {
                int newCount = registry.get(that.charAt(i)) - 1;
                if(newCount == 0) {
                    registry.remove(that.charAt(i));
                } else {
                    registry.put(that.charAt(i),newCount);
                }

            }
        }
        return "YES";
    }

    private String isRepeatingChar(String target) {
        Set<Character> registry = new HashSet();
        for(int i = 0 ; i < target.length() ; i++) {
            if(registry.contains(target.charAt(i))) {
                return "YES";
            } else {
                registry.add(target.charAt(i));
            }
        }
        return "NO";
    }

    private char[] reverseC(char[] chars, int start, int end) {
        if(end <= start) return chars;
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        reverseC(chars, start + 1, end - 1);
        return chars;
    }

    private boolean isPallindrome(String target) {
        for(int i = 0, j = target.length()-1 ; i < j ; i++,j-- ) {
            if(target.charAt(i)!=target.charAt(j)){
                return true;
            }
        }
        return false;
    }

    private boolean isPallindromeR(String target) {
        if(target.length()==1) return true;
        if(target.charAt(0) == target.charAt(target.length()-1)) {
            return isPallindromeR(target.substring(1,target.length()-1));
        }
        return false;
    }

    private void reverse(String target, int index, StringBuilder buffer) {
        if(index == target.length()) return;
        reverse(target,++index,buffer);
        buffer.append(target.charAt(index-1));
    }
}
