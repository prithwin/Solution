package com.personal;

/**
 * Created by prajeeva on 9/17/17.
 */
public class StringRotation {
    //check if a string is a rotation of the other string
    public static void main(String[] args) {
        String one = "ABCDEFGHI";
        String two = "FGHIABCDE";
        //now to check if one is a rotation of the other
        String oneone = one + one;
        System.out.println(oneone);
        System.out.println(oneone.contains(two));

    }
}
