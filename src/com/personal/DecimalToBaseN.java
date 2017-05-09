package com.personal;

import com.personal.util.Mathematical;

/**
 * Created by pr250155 on 5/8/17.
 */
public class DecimalToBaseN {

    public String decimalToBaseN(int decimal,int base) {
        StringBuilder basedRepresenation = new StringBuilder();
        int number = decimal;
        int reminder = 0;
        int quotient = number;
        while(quotient > 0 ){
            quotient = number / base;
            reminder = number % base;
            basedRepresenation.append((char)getBaseChacter(reminder));
            number = quotient;
        }
        return basedRepresenation.reverse().toString();
    }

    public int baseNToDecimal(String basedRepresentation, int base) {
        int sum = 0;
        int power = 0 ;
        for(int i = basedRepresentation.length()-1 ; i >=0 ;i--) {
            int number = Integer.parseInt(getNumber(basedRepresentation.charAt(i)));
            sum += number * Mathematical.power(base,power++);
        }
        return sum;
    }

    private String getNumber(char c) {
        if(c >= 48 && c<=57) {
            return c+"";
        } else {
            return (c-55)+"";
        }
    }

    private int getBaseChacter(int number) {
        int base = 0;
        if(number >=0 && number <=9){
            base=48;
        } else {
            base=55;
        }
        return base+number;
    }
}
