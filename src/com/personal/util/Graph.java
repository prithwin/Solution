package com.personal.util;

import java.util.*;
import java.util.LinkedList;

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

    public void printBreadthFirstSearch(int index) {
        if(type.isMatrix()){
            Queue<Integer> printQueue = new java.util.LinkedList();
            List<Integer> visited = new ArrayList();
            printQueue.add(index);
            bfsInternal(printQueue,visited);
        }
    }

    private void bfsInternal(Queue<Integer> printQueue, List<Integer> visited) {
        if(printQueue.isEmpty()) return;
        int index = printQueue.poll();
        System.out.println(graphNodes.get(index).readableName);
        visited.add(index);
        for(int j = 0 ; j < adjecencyMatrix[index].length ;j++) {
            if(adjecencyMatrix[index][j] != 0) {
                if(!visited.contains(j)) {
                    printQueue.offer(j);
                }
            }
        }
        bfsInternal(printQueue,visited);
    }

    private void printDepthFirstSearchInternal(int index,List<Integer> visited) {
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

    public boolean hasCycles() {
        return false;
    }

    public DisjointSet getKruskalMST() {
        if(type.isMatrix()) {
            List<ComparableEdge> comparableEdges = getAsListOfComparableEdges();
            List<ComparableEdge> sortedList = new Sorter<ComparableEdge>().mergeSort(comparableEdges);
            DisjointSet result = new DisjointSet(sortedList.size());
            result.union(sortedList.get(0).from,sortedList.get(0).to);
            for(int i = 1 ; i < sortedList.size() ; i++) {
                result.union(sortedList.get(i-1).to,sortedList.get(i).to);
            }
            return result;
        }
        return new DisjointSet(0);
    }

    private List<ComparableEdge> getAsListOfComparableEdges() {
        List<ComparableEdge> edgeList = new LinkedList();
        if(type.isMatrix()) {
            for(int i = 0 ; i < adjecencyMatrix.length ; i++) {
                for (int j = 0; j < adjecencyMatrix[i].length; j++) {
                    if(adjecencyMatrix[i][j] != 0) {
                        ComparableEdge edge = new ComparableEdge();
                        edge.from = i;
                        edge.to = j;
                        edge.weight = adjecencyMatrix[i][j];
                        edgeList.add(edge);
                    }
                }
            }
        }
        return edgeList;
    }

}
