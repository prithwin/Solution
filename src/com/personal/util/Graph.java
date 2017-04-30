package com.personal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.personal.util.GraphType.UNDIRECTED_MATRIX;

/**
 * Created by pr250155 on 4/29/17.
 */
public class Graph {

    Map<Integer,GraphNode> graphNodes;
    int[][] adjecencyMatrix;
    List<List<GraphNode>> adjacencyList;
    GraphType type;

    public Graph(int[][] adjecencyMatrix, Map<Integer , GraphNode> graphNodes) {
        this.adjecencyMatrix = adjecencyMatrix;
        this.graphNodes = graphNodes;
        this.type = UNDIRECTED_MATRIX;
    }

    public Graph(Map<Integer,GraphNode> graphNodes,GraphType type) {
        if(type.isMatrix()) {
            if(adjecencyMatrix == null) {
                adjecencyMatrix = new int[graphNodes.size()][graphNodes.size()];
            }
        }
        this.graphNodes = graphNodes;
        this.type = type;
    }

    public void addEdge(int a , int b) {
        if(type.isDirected()){
            if(type.isMatrix()) {
                adjecencyMatrix[a][b] = 1;
            }
        } else {
            if(type.isMatrix()) {
                adjecencyMatrix[a][b] = 1;
                adjecencyMatrix[b][a] = 1;
            }
        }
    }

    public void printDepthFirstSearch(int index) {
        if(type.isMatrix()) {
            printDepthFirstSearchInternal(index, new ArrayList<>());
        }
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
