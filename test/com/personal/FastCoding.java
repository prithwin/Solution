package com.personal;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by prajeeva on 10/28/17.
 */
public class FastCoding {
    @Test
    public void reverseString() {
        String target = "Prithwin";
        System.out.println(new String(reverse(target.toCharArray())));
    }

    private char[] reverse(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        while(start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }

    @Test
    public void rotateArray() {
        int[] target = {1,2,3,4,5,6,7};
        int k = 2;
        k=k % target.length;
        int dir = -1;
        if(dir == -1) {
            k = target.length -k;
        }

        reverse(target , 0 , target.length - 1);
        reverse(target , k , target.length - 1 );
        reverse(target , 0 , k -1);
        Arrays.stream(target).forEach(System.out::println);

    }

    private void reverse(int[] target , int start , int end) {
        while(start < end) {
            int temp = target[start];
            target[start] = target[end];
            target[end] = temp;
            start++;
            end--;
        }
    }


}
