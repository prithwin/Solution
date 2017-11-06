package com.design.patterns.singleton;

/**
 * Created by prajeeva on 11/2/17.
 */
public enum BetterFileSystem {
    INSTANCE("","");

    BetterFileSystem(String host, String port) {
        a = 3;
        b = 7;
    }

    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
