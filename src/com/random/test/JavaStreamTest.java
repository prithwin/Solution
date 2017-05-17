package com.random.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * Created by pr250155 on 5/17/17.
 */
public class JavaStreamTest {
    public static void main(String[] args) {
        byte[] test = new byte[3];
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        bos.write(65);

        ByteArrayInputStream bis = new ByteArrayInputStream(test);
        test[0] = 65;
        System.out.println(bis.read());
        test[1] = 66;
        System.out.println(bis.read());
        test[2] = 67;
        System.out.println(bis.read());

    }
}
