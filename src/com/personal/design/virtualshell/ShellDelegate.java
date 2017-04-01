package com.personal.design.virtualshell;

import java.util.ArrayList;
import java.util.List;

public class ShellDelegate {
    Directory root;
    Directory pwd;

    public ShellDelegate() {
        this.root = new Directory();
        this.pwd = this.root;
    }

    public static void intitializeShell(Shell shell) {
        ;
    }

    public void cd(String relativePath) {
        if (contains(this.pwd.directories, relativePath)) {
            for (Directory nameable : this.pwd.directories) {
                if (nameable.name.equals(relativePath)) {
                    pwd = nameable;
                }
            }
        } else {
            System.out.println("cant change to nonexistent directory");
        }
    }

    boolean contains(List<? extends Namable> items, String relativePath) {
        for (Namable nameable : items) {
            if (nameable.name.equals(relativePath))
                return true;
        }
        return false;
    }

    public void ls() {
        for (Directory nameable : this.pwd.directories) {
            System.out.println(nameable.name);
        }

        for (File nameable : this.pwd.files) {
            System.out.println(nameable.name);
        }
    }

    public void ls(String tab, Directory directory) {
        for (Directory nameable : directory.directories) {
            System.out.println(tab + "+" + nameable.name);
        }

        for (File nameable : directory.files) {
            System.out.println(tab + "-" + nameable.name);
        }
    }

    public void mkdir(String folderName) {
        if (!contains(this.pwd.directories, folderName) && !contains(this.pwd.files, folderName)) {
            Directory directory = new Directory();
            directory.name = folderName;
            this.pwd.directories.add(directory);
        } else {
            System.out.println("file or directory already exists");
        }
    }

    public void tree(Directory directory, String tab) {
        if(directory.files.size()>0){
            for (int i = directory.files.size()-1 ;i >=0;i--) {
                File file  = directory.files.get(i);
                System.out.println(tab + "-"+file.name);
            }
        }
        if (directory.directories.size() > 0) {
            //there are some dirs
            //print all the files in the current directory

            for (int i =directory.directories.size()-1 ;i >=0;i--) {
                Directory dir  = directory.directories.get(i);
                System.out.println(tab +"+"+dir.name);
                tree(dir, tab + "\t");
            }

        }
    }

    public void mkFile(String fileName) {
        if (!contains(this.pwd.directories, fileName) && !contains(this.pwd.files, fileName)) {
            File file = new File();
            file.name = fileName;
            this.pwd.files.add(file);
        } else {
            System.out.println("file or directory already exists");
        }
    }

    public void reset() {
        this.pwd = root;
    }
}


class Namable{
    String name;
}

class Directory extends Namable {
    List<Directory> directories = new ArrayList<Directory>();
    List<File> files = new ArrayList<File>();
}

class File extends Namable {

}