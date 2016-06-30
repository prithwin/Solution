package com.personal;

/**
 * Created by pr250155 on 5/6/16.
 */
public class TestMiddleNameGenerator {

    public String createMiddleName(String[] names) {
        StringBuilder middleNameBuilder = new StringBuilder();
        if (names.length==2) {
            return "";
        }
        for (int i = 1; i <= names.length - 2; i++){
            middleNameBuilder.append(names[i]).append(" ");
        }
        return middleNameBuilder.toString().trim();
    }

    public static void main(String[] args){
        String[] names = new String[4];
        names[0]="sooper";
        names[1]="dooper";
        names[2]="schmooper";
        names[3]="bloooper";

        System.out.println("|"+new TestMiddleNameGenerator().createMiddleName(names)+"|");
    }
}
