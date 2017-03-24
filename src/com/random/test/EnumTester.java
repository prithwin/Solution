package com.random.test;

/**
 * Created by pr250155 on 3/23/17.
 */
public class EnumTester {
    public static void main(String[] args) {
        Raga bhoop = new Raga();
        bhoop.vadi = Swaras.GA;
        if (bhoop.vadi == Swaras.GA){
            System.out.println("vadi is ga");
            Swaras.SA.strikeFrequency();
        }
    }

}
enum Swaras {
    SA{
        void strikeFrequency(){
            System.out.println("Sa");
        };

    },RE{
        @Override
        void strikeFrequency() {

        }
    },GA{
        @Override
        void strikeFrequency() {

        }
    },MA{
        @Override
        void strikeFrequency() {

        }
    },PA{
        @Override
        void strikeFrequency() {

        }
    },DHA{
        @Override
        void strikeFrequency() {

        }
    },NI{
        @Override
        void strikeFrequency() {

        }
    };
    abstract void strikeFrequency();
}

class Raga {
    Swaras vadi;
}