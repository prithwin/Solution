package com.random.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

class LambdasTest {
    static class Image {
        int width;
        int height;

        Image(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int L = s.nextInt();
        int N = s.nextInt();
        List<Image> images = new ArrayList<>();
        BufferedReader inputreader = new BufferedReader(new InputStreamReader(System.in));
        for ( int i = 0 ; i < N ; i++ ) {
            String[] imageLines = inputreader.readLine().split(" ");
            images.add(new Image(Integer.parseInt(imageLines[0]),Integer.parseInt(imageLines[1])));
        }
        images.stream().forEach(i -> processImageAndPrint(i,L));
    }

    private static void processImageAndPrint(Image image, int requiredLength) {
        if(image.width < requiredLength || image.height < requiredLength) {
            System.out.println("UPLOAD ANOTHER");
        } else if (image.width >= requiredLength && image.height >= requiredLength)  {
            if(image.width == image.height) {
                System.out.println("ACCEPTED");
            } else {
                System.out.println("CROP IT");
            }
        }
    }
}
