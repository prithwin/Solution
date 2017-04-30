package com.personal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pr250155 on 4/29/17.
 */
public class Graph {

    Map<Integer,GraphNode> graphNodes;
    int[][] adjecencyMatrix;

    public Graph(int[][] adjecencyMatrix, Map<Integer , GraphNode> graphNodes) {
        this.adjecencyMatrix = adjecencyMatrix;
        this.graphNodes = graphNodes;
    }

    public void printDepthFirstSearch(int index) {
        printDepthFirstSearchInternal(index , new ArrayList<>());
    }

    public void printDepthFirstSearchInternal(int index,List<Integer> visited) {
        System.out.println(graphNodes.get(index).readableName);
        visited.add(index);
        for(int j = 0 ; j < adjecencyMatrix[index].length ; j++){
            if(adjecencyMatrix[index][j] != 0) {
                //there is an edge
                if(!visited.contains(j)) {
                    printDepthFirstSearchInternal(j, visited);
                }
            }
        }
    }

}
