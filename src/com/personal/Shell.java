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
    final ShellDelegate shellDelegate = new ShellDelegate();

    public void cd(String relativePath){
        shellDelegate.cd(relativePath);
    }

    public void reset(){
        shellDelegate.reset();
    }
    private boolean contains(List<? extends Namable> items, String relativePath) {
        return shellDelegate.contains(items, relativePath);
    }

    public void ls(){

        shellDelegate.ls();
    }

    public void ls(String tab, Directory directory){

        shellDelegate.ls(tab, directory);
    }

    public void mkdir(String folderName){
        shellDelegate.mkdir(folderName);
    }

    public void tree(Directory directory,String tab){
        shellDelegate.tree(directory, tab);
    }

    public void mkFile(String fileName){
        shellDelegate.mkFile(fileName);
    }

    public static void main(String[] args) {
        Shell shell  = new Shell();
        shell.shellDelegate.intitializeShell(shell);
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

            if(command.startsWith("reset")) {
                shell.reset();
            }

            if(command.startsWith("tree")) {
                shell.tree(shell.shellDelegate.root,"");
            }
      }
    }
}
