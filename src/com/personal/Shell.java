package com.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajeev on 3/3/17.
 */

public class Shell {
    Directory root;
    Directory pwd;

    public void cd(String relativePath){
        if(contains(this.pwd.directories,relativePath)){
            for(Directory nameable : this.pwd.directories){
                if(nameable.name.equals(relativePath)){
                    pwd = nameable;
                }
            }
        }
        else {
            System.out.println("cant change to nonexistent directory");
        }
    }

    private boolean contains(List<? extends Namable> items, String relativePath) {
        for(Namable nameable : items){
            if(nameable.name.equals(relativePath))
                return true;
        }
        return false;
    }

    public void ls(){
        for(Directory nameable : this.pwd.directories){
           System.out.println(nameable.name);
        }

        for(File nameable : this.pwd.files){
            System.out.println(nameable.name);
        }
    }

    public void ls(String tab, Directory directory){
        for(Directory nameable : directory.directories){
            System.out.println(tab+"+"+nameable.name);
        }

        for(File nameable : directory.files){
            System.out.println(tab+"-"+nameable.name);
        }
    }

    public void mkdir(String folderName){
        if(!contains(this.pwd.directories,folderName) && !contains(this.pwd.files,folderName)) {
            Directory directory = new Directory();
            directory.name = folderName;
            this.pwd.directories.add(directory);
        }else {
            System.out.println("file or directory already exists");
        }
    }

    public void tree(Directory directory,String tab){
        this.ls(tab,directory);
        if(directory.directories.size()>0){
            //there are some di
            for (Directory dir: directory.directories) {
                tree(dir,tab+"\t");
            }
        }
    }

    public void mkFile(String fileName){
        if(!contains(this.pwd.directories,fileName) && !contains(this.pwd.files,fileName)) {
            File file = new File();
            file.name = fileName;
            this.pwd.files.add(file);
        }else {
            System.out.println("file or directory already exists");
        }
    }

    public static void main(String[] args) {
        Shell shell  = new Shell();
        shell.root = new Directory();
        shell.pwd = shell.root;
        String command="";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!command.equals("exit")){
            try {
                command= br.readLine();
            } catch (IOException e) {
                command ="exit";
            }
            if(command.startsWith("mkdir")){
              String fileName = command.split(" ")[1];
              shell.mkdir(fileName);
          }

          if(command.startsWith("mkfile")){
              String fileName = command.split(" ")[1];
              shell.mkFile(fileName);
          }

          if(command.startsWith("ls")){
              shell.ls();
          }
          if(command.startsWith("cd")) {
              String fileName = command.split(" ")[1];
              shell.cd(fileName);
          }

            if(command.startsWith("tree")) {
                shell.tree(shell.root,"");
            }
      }


        //once the root directory iscreated you can do the things


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