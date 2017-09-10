package com.random.test;

import java.sql.SQLException;

/**
 * Created by prajeeva on 9/6/17.
 */
public class Dog extends Animal {
    @Override
    public MyException someThing(Exception someThing) throws MyException {
        //return super.someThing(someThing);
        return null;
    }
}

class MyException extends SQLException {

}



