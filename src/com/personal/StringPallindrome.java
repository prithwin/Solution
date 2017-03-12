package com.personal;

/**
 * Created by prajeev on 10/3/17.
 */
public class StringPallindrome {
    public static void main(String[] args) {
        String checkString = "DO33OD";
        System.out.println("This is pallindrome.");
        for(int i= 0,j=checkString.length()-1 ; i <= ((checkString.length()/2)-1) ;i++,j--){
            if(checkString.charAt(i)!=checkString.charAt(j)){
                System.out.println("NOT!");
                break;
            }
        }
    }
}
