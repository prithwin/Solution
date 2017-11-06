package com.random.test.old;

/**
 * Created by prajeeva on 10/31/17.
 */
public class AbstractClassVsInterfaces {
    public static void main(String[] args) {
        getI().youMustDoSomething(3455);
        getA().youMustDoSomething(34534);

        synchronized (Animal.class) {
            System.out.println("Something is going on man");
        }

        synchronized (ClassAnnotation.class) {
            System.out.println("Something is going on man");
        }


    }

    public static synchronized SomeInterface getI() {
        return new SomeInterfaceImpl();
    }

    public static SomeAbstractClass getA() {
        return new SomeAbstractClassImpl();
    }
}
