package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 4/15/17.
 */
public class TowersOfHanoi {

    public int numberOfMoves(int size){
        if(size == 1){
            return 1;
        } else {
            return numberOfMoves(size-1) + 1 + numberOfMoves(size-1);
        }
    }

    public void printMoves(int size){
        printMovesInternal(size,"A","C","B");
    }

    private void printMovesInternal(int size, String source, String destination, String temp) {
        if(size == 1){
            System.out.printf("Move %s ----> %s\n",source,destination);
        } else {
            printMovesInternal(size-1,source,temp,destination);
            System.out.printf("Move %s ----> %s\n",source,destination);
            printMovesInternal(size-1,temp,destination,source);
        }
    }

}
