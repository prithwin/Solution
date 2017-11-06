package com.design.patterns.singleton;

/**
 * Created by prajeeva on 11/5/17.
 */
public class AllClasses {
    //these are all the possible ways you can create
    public static class PlainAndSimple {
        private static PlainAndSimple instance;
        private int a;
        private int b;
        private int c;
        private int d;

        private PlainAndSimple() {}

        static {
            instance = new PlainAndSimple();
        }
        public static PlainAndSimple getInstance() {
            return instance;
        }
    }

    public static class PlainAndSimple2 {
        private static PlainAndSimple2 instance;
        private int a;
        private int b;
        private int c;
        private int d;

        private PlainAndSimple2(int a, int b , int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public static PlainAndSimple2 getInstance(int a , int b , int c, int d) {
            if(instance == null) {
                instance = new PlainAndSimple2(a,b,c,d);
            }
            return instance;
        }
    }
}
