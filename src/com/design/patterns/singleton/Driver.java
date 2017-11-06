package com.design.patterns.singleton;

/**
 * Created by prajeeva on 11/5/17.
 */
public class Driver {
    public static void main(String[] args) {
        AllClasses.PlainAndSimple plainAndSimple = AllClasses.PlainAndSimple.getInstance();

        AllClasses.PlainAndSimple2 ps2 = AllClasses.PlainAndSimple2.getInstance(1,2,3,4);
        System.out.println();
    }
}
