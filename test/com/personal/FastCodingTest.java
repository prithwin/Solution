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
