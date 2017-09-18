package com.random.test;


import com.personal.util.BinaryTree;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class OTP {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(new String(Base64.getEncoder().encode(java.security.MessageDigest.getInstance("MD5").digest("http://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash".getBytes()))));
    }
}