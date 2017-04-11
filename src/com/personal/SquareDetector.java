package com.personal;

import sun.plugin.dom.core.CoreConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajeev on 14/3/17.
 */
public class SquareDetector {

    public static void main(String[] args) {
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(15,8));
        coordinates.add(new Coordinate(3,14));
        coordinates.add(new Coordinate(5,1));
        coordinates.add(new Coordinate(6,19));
        coordinates.add(new Coordinate(2,7));
        coordinates.add(new Coordinate(1,1));
        coordinates.add(new Coordinate(1,2));
        coordinates.add(new Coordinate(2,2));
        coordinates.add(new Coordinate(2,1));
        coordinates.add(new Coordinate(3,5));
        coordinates.add(new Coordinate(7,1));
        coordinates.add(new Coordinate(9,6));
        coordinates.add(new Coordinate(34,7));
        boolean rectangleFound = false;
        for(Coordinate item : coordinates){
            //check if there are others point with the same
            List<Coordinate> allVerticalCordinates = Coordinate.findY(item.x, coordinates,item);
            List<Coordinate> allHorizontalCoordinates = Coordinate.findX(item.y, coordinates,item);
            if(!allHorizontalCoordinates.isEmpty() && !allVerticalCordinates.isEmpty()){
                for(Coordinate vertical : allVerticalCordinates){
                    for (Coordinate horizontal : allHorizontalCoordinates){
                        if(!Coordinate.findXY(horizontal.y,vertical.x,coordinates).isEmpty()){
                            rectangleFound = true;
                        }
                    }
                }
            }
        }
        if(rectangleFound){
            System.out.println("rectangle detected!");
        } else {
            System.out.println("no rectangle found!");
        }
    }
    //detects squares and Rectangles
    static class Coordinate {
        int x;
        int y;

        public Coordinate(){

        }
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static List<Coordinate> findY(int x, List<Coordinate> coordinates, Coordinate exclude){
            List<Coordinate> returnList = new ArrayList<Coordinate>();
            for(Coordinate coordinate : coordinates){
                if(coordinate.x == x && coordinate.y!=exclude.y){
                    returnList.add(coordinate);
                }
            }
            return returnList;
        }

        public static List<Coordinate>  findX(int y, List<Coordinate> coordinates, Coordinate exclude){
            List<Coordinate> returnList = new ArrayList<Coordinate>();
            for(Coordinate coordinate : coordinates){
                if(coordinate.y == y && coordinate.x!=exclude.x){
                    returnList.add(coordinate);
                }
            }
            return returnList;

        }

        public static List<Coordinate> findXY(int x, int y,List<Coordinate>  coordinates){
            List<Coordinate> returnList = new ArrayList<Coordinate>();
            for(Coordinate coordinate : coordinates){
                if(coordinate.y == y && coordinate.x==x){
                    returnList.add(coordinate);
                }
            }
            return returnList;
        }
    }

}
