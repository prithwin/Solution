package com.personal;

/**
 * Created by pr250155 on 3/26/17.
 */
public class DnQFactorial {
    public int factorial(int upper, int lower){
        if(upper==lower){
            return upper;
        }
        if(lower>upper){
            return 1;
        }

        return factorial(upper,((upper+lower)/2)+1)*factorial(((upper+lower)/2),lower);
    }


    public static void main(String[] args) {
        System.out.println(new DnQFactorial().factorial(7,1));
    }
}