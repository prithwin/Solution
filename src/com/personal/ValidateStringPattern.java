package com.personal;

/**
 * Created by pr250155 on 4/24/17.
 */
public class ValidateStringPattern {

    public static void main(String[] args) {
        String target = "aertbertcertg";
        String pattern = "abcd";
        System.out.println(new ValidateStringPattern().validate(target,pattern));
    }

    private boolean validate(String target, String pattern) {
        if(pattern.length()==1){
             return target.contains(pattern);
        } else {
            if(target.contains(pattern.charAt(0)+"")){
                return validate(target.substring(target.indexOf(pattern.charAt(0))) , pattern.substring(1));
            } else {
                return false;
            }
        }
    }
}
