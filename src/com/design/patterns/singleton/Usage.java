package com.design.patterns.singleton;

import static com.design.patterns.singleton.BetterFileSystem.*;

/**
 * Created by prajeeva on 11/2/17.
 */
public class Usage {
    public static void main(String[] args) {
        int a = INSTANCE.getA();
    }

}
