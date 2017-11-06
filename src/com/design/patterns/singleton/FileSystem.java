package com.design.patterns.singleton;

import java.io.File;

/**
 * the fileSystem does some wired things to your file.
 */
public class FileSystem {
    private static FileSystem instance = new FileSystem();

    private FileSystem() {

    }

    public static void main(String[] args) {

    }

    public static FileSystem getInstance() {
        return instance;
    }
}
